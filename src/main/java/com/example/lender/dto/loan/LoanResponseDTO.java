package com.example.lender.dto.loan;

import lombok.Data;

@Data
public class LoanResponseDTO {

    private Long id;

    // Borrower info
    private Long borrowerId;
    private String borrowerName;

    // Lender info
    private Long lenderId;
    private String lenderName;

    // Loan details
    private Double principal;   // mapped from amount
    private Double interestRate;
    private Integer tenureMonths;

    private Double monthlyEmi;  // calculated later
    private String status;
}
