package com.example.lender.repository;

import com.example.lender.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByBorrowerId(Long borrowerId);

    long countByStatus(String status);
}
