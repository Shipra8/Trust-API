package com.example.lender.service;

import com.example.lender.dto.request.LoanRequestDTO;
import com.example.lender.dto.response.LoanResponseDTO;
import com.example.lender.entity.Borrower;
import com.example.lender.entity.Lender;
import com.example.lender.entity.Loan;
import com.example.lender.exception.BusinessException;
import com.example.lender.exception.ResourceNotFoundException;
import com.example.lender.repository.BorrowerRepository;
import com.example.lender.repository.LenderRepository;
import com.example.lender.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BorrowerRepository borrowerRepository;
    private final LenderRepository lenderRepository;

    public LoanService(LoanRepository loanRepository,
                       BorrowerRepository borrowerRepository,
                       LenderRepository lenderRepository) {
        this.loanRepository = loanRepository;
        this.borrowerRepository = borrowerRepository;
        this.lenderRepository = lenderRepository;
    }

    public LoanResponseDTO create(LoanRequestDTO dto) {
        Borrower borrower = borrowerRepository.findById(dto.getBorrowerId())
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found"));

        Lender lender = lenderRepository.findById(dto.getLenderId())
                .orElseThrow(() -> new ResourceNotFoundException("Lender not found"));

        if (dto.getAmount() <= 0) throw new BusinessException("Invalid amount");

        Loan loan = new Loan();
        loan.setBorrower(borrower);
        loan.setLender(lender);
        loan.setAmount(dto.getAmount());
        loan.setInterestRate(dto.getInterestRate());
        loan.setTenureMonths(dto.getTenureMonths());
        loan.setStatus("PENDING");

        return toDto(loanRepository.save(loan));
    }

    public List<LoanResponseDTO> getAll() {
        return loanRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void approveLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        loan.setStatus("APPROVED");
        loanRepository.save(loan);
    }

    public void rejectLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        loan.setStatus("REJECTED");
        loanRepository.save(loan);
    }

    private LoanResponseDTO toDto(Loan loan) {
        LoanResponseDTO dto = new LoanResponseDTO();
        dto.setId(loan.getId());
        dto.setAmount(loan.getAmount());
        dto.setInterestRate(loan.getInterestRate());
        dto.setTenureMonths(loan.getTenureMonths());
        dto.setStatus(loan.getStatus());
        return dto;
    }
}