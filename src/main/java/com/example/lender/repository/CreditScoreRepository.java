package com.example.lender.repository;

import com.example.lender.entity.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {

    Optional<CreditScore> findByBorrowerId(Long borrowerId);
}
