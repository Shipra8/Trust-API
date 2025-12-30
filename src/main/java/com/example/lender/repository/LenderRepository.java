package com.example.lender.repository;

import com.example.lender.entity.Lender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LenderRepository extends JpaRepository<Lender, Long> {
}
