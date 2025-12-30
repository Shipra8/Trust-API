package com.example.lender.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long borrowerId;
    private Integer score;
    private String grade;
    private String riskLevel;
    private LocalDateTime calculatedAt;
}
