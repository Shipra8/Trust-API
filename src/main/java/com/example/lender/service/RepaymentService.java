package com.example.lender.service;

import com.example.lender.dto.request.RepaymentRequestDTO;
import com.example.lender.dto.response.RepaymentResponseDTO;
import com.example.lender.entity.Loan;
import com.example.lender.entity.Repayment;
import com.example.lender.exception.BusinessException;
import com.example.lender.exception.ResourceNotFoundException;
import com.example.lender.repository.LoanRepository;
import com.example.lender.repository.RepaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepaymentService {

    private final RepaymentRepository repaymentRepository;
    private final LoanRepository loanRepository;

    public RepaymentService(RepaymentRepository repaymentRepository,
                            LoanRepository loanRepository) {
        this.repaymentRepository = repaymentRepository;
        this.loanRepository = loanRepository;
    }

    public RepaymentResponseDTO makePayment(RepaymentRequestDTO dto) {
        Loan loan = loanRepository.findById(dto.getLoanId())
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        if (!loan.getStatus().equals("APPROVED")) {
            throw new BusinessException("Loan not approved");
        }

        Repayment repayment = new Repayment();
        repayment.setLoan(loan);
        repayment.setAmountPaid(dto.getAmountPaid());
        repayment.setPaymentDate(LocalDate.now());

        Repayment saved = repaymentRepository.save(repayment);

        RepaymentResponseDTO response = new RepaymentResponseDTO();
        response.setId(saved.getId());
        response.setAmountPaid(saved.getAmountPaid());
        response.setPaymentDate(saved.getPaymentDate().toString());

        return response;
    }

    public List<RepaymentResponseDTO> getByLoan(Long loanId) {
        return repaymentRepository.findByLoanId(loanId)
                .stream()
                .map(r -> {
                    RepaymentResponseDTO dto = new RepaymentResponseDTO();
                    dto.setId(r.getId());
                    dto.setAmountPaid(r.getAmountPaid());
                    dto.setPaymentDate(r.getPaymentDate().toString());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
