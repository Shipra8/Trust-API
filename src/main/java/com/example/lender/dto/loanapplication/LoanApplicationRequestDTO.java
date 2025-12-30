package com.example.lender.dto.loanapplication;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoanApplicationRequestDTO {
    @NotNull
    private Long userId;

    @NotNull
    @Min(value = 1000, message = "Minimum loan amount is 1000")
    private Double loanAmount;

    @NotNull
    @Min(value = 1, message = "Tenure must be at least 1 month")
    private Integer tenureMonths;

    // Optional - could be a file reference or a small doc id
    private String kycDocument;
}
