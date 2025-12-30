package com.example.lender.dto.loanapplication;

import lombok.Data;

@Data
public class LoanApplicationResponseDTO {
    private Long id;
    private Long userId;
    private Double loanAmount;
    private Integer tenureMonths;
    private String status;
    private String kycDocument;
}
