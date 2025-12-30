package com.example.lender.repository;

import com.example.lender.entity.CreditProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditProfileRepository extends JpaRepository<CreditProfile, Long> {

    Optional<CreditProfile> findByBorrowerId(Long borrowerId);
}
