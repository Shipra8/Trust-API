package com.example.lender.dto.emi;

import lombok.Data;

@Data
public class EMIResponseDTO {
    private Long id;
    private Long loanId;
    private Integer monthNumber;
    private Double emiAmount;
    private String dueDate; // ISO date string
    private Boolean paid;
}
