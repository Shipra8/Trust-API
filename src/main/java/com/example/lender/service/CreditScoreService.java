package com.example.lender.service;

import com.example.lender.entity.Borrower;
import com.example.lender.entity.CreditScore;
import com.example.lender.repository.BorrowerRepository;
import com.example.lender.repository.CreditScoreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreditScoreService {

    private final BorrowerRepository borrowerRepo;
    private final CreditScoreRepository creditRepo;

    public CreditScoreService(BorrowerRepository borrowerRepo,
                              CreditScoreRepository creditRepo) {
        this.borrowerRepo = borrowerRepo;
        this.creditRepo = creditRepo;
    }

    public CreditScore generate(Long borrowerId) {

        Borrower b = borrowerRepo.findById(borrowerId)
                .orElseThrow(() -> new RuntimeException("Borrower not found"));

        int score = 300;

        score += b.getAnnualIncome() >= 1_000_000 ? 150 : 100;
        score += "SALARIED".equalsIgnoreCase(b.getEmploymentType()) ? 100 : 50;
        score -= b.getPastDefaults() * 50;

        score = Math.max(300, Math.min(900, score));

        String grade = score >= 750 ? "A" : score >= 650 ? "B" : "C";
        String risk = score >= 750 ? "LOW" : score >= 650 ? "MEDIUM" : "HIGH";

        CreditScore cs = CreditScore.builder()
                .borrowerId(borrowerId)
                .score(score)
                .grade(grade)
                .riskLevel(risk)
                .calculatedAt(LocalDateTime.now())
                .build();

        return creditRepo.save(cs);
    }
}
