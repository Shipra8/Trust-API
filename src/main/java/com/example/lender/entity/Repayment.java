package com.example.lender.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "repayments")
public class Repayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ LINK TO LOAN
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    // ✅ PAYMENT DETAILS
    private double amountPaid;
    private LocalDate paymentDate;
}
