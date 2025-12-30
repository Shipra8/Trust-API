package com.example.lender.dto.payment;

import lombok.Data;

@Data
public class PaymentResponseDTO {
    private Long id;
    private Long emiId;
    private Long loanId;
    private Long userId;
    private Double amount;
    private String paymentDate;
    private String paymentReference;
    private String status;
}
