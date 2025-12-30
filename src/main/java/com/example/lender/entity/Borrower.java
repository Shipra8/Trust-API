package com.example.lender.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "borrowers")
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;

    private Integer annualIncome;
    private String employmentType; // SALARIED / SELF_EMPLOYED
    private Integer existingLoans;
    private Integer pastDefaults;
}
