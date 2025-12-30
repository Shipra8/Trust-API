package com.example.lender.dto.request;

import lombok.Data;

@Data
public class BorrowerRequestDTO {
    private String fullName;
    private String email;
    private String phone;
    private Integer annualIncome;
    private String employmentType;
    private Integer existingLoans;
    private Integer pastDefaults;
}
