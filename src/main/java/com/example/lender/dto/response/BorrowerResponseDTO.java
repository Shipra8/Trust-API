package com.example.lender.dto.response;

import lombok.Data;

@Data
public class BorrowerResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Integer annualIncome;
    private String existingLoans;
    private Integer pastDefaults;
}
