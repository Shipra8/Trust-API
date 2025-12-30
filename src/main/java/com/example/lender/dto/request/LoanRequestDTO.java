package com.example.lender.dto.request;

import lombok.Data;

@Data
public class LoanRequestDTO {

    private Long borrowerId;
    private Long lenderId;
    private Double amount;
    private Double interestRate;
    private Integer tenureMonths;
}
