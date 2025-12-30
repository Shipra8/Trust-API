package com.example.lender.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credit_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One borrower → one credit profile
    @OneToOne
    @JoinColumn(name = "borrower_id", nullable = false, unique = true)
    private Borrower borrower;

    // Core inputs for credit score
    private Integer monthlyIncome;
    private Integer existingEmis;
    private Integer activeLoans;
    private Integer missedPaymentsLast6Months;

    // Derived output
    private Integer creditScore;
}
