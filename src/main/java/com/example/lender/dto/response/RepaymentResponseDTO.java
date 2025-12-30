package com.example.lender.dto.response;

import lombok.Data;

@Data
public class RepaymentResponseDTO {

    private Long id;
    private Long loanId;
    private Double amountPaid;
    private String paymentDate;
}
