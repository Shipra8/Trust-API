package com.example.lender.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditScoreResponseDTO {

    private Long borrowerId;
    private Integer score;
    private String grade;
    private String riskLevel;
}
