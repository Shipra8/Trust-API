package com.example.lender.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Borrower borrower;

    @ManyToOne
    private Lender lender;

    private double amount;
    private double interestRate;
    private int tenureMonths;
    private double emi;

    private String status;

    private LocalDate startDate;
    private LocalDate endDate;
}
