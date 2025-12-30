package com.example.lender.service;

import com.example.lender.dto.request.BorrowerRequestDTO;
import com.example.lender.dto.response.BorrowerResponseDTO;
import com.example.lender.entity.Borrower;
import com.example.lender.repository.BorrowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowerService {

    private final BorrowerRepository repository;

    public BorrowerService(BorrowerRepository repository) {
        this.repository = repository;
    }

    public BorrowerResponseDTO create(BorrowerRequestDTO dto) {
        Borrower borrower = new Borrower();
        borrower.setFullName(dto.getFullName());
        borrower.setEmail(dto.getEmail());
        borrower.setPhone(dto.getPhone());
        borrower.setAnnualIncome(dto.getAnnualIncome());
        borrower.setEmploymentType(dto.getEmploymentType());
        borrower.setExistingLoans(dto.getExistingLoans());
        borrower.setPastDefaults(dto.getPastDefaults());

        Borrower saved = repository.save(borrower);
        return toDto(saved);
    }

    public List<BorrowerResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private BorrowerResponseDTO toDto(Borrower borrower) {
        BorrowerResponseDTO dto = new BorrowerResponseDTO();
        dto.setId(borrower.getId());
        dto.setFullName(borrower.getFullName());
        dto.setEmail(borrower.getEmail());
        dto.setPhone(borrower.getPhone());
        dto.setAnnualIncome(borrower.getAnnualIncome());
        dto.setExistingLoans(borrower.getExistingLoans().toString());
        dto.setPastDefaults(borrower.getPastDefaults());
        return dto;
    }
}
