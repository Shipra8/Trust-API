package com.example.lender.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanResponseDTO {

    private Long id;
    private Long borrowerId;
    private Long lenderId;
    private Double amount;
    private Double interestRate;
    private Integer tenureMonths;
    private Double emi;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
}
