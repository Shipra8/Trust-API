package com.example.lender.dto.request;

import lombok.Data;

@Data
public class RepaymentRequestDTO {

    private Long loanId;
    private Double amountPaid;
}
