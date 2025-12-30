package com.example.lender.service.credit;

import com.example.lender.entity.Borrower;
import com.example.lender.entity.CreditProfile;
import com.example.lender.repository.BorrowerRepository;
import com.example.lender.repository.CreditProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditProfileService {

    private final CreditProfileRepository creditProfileRepo;
    private final BorrowerRepository borrowerRepo;
    private final CreditScoreCalculator calculator;

    public CreditProfileService(
            CreditProfileRepository creditProfileRepo,
            BorrowerRepository borrowerRepo,
            CreditScoreCalculator calculator) {
        this.creditProfileRepo = creditProfileRepo;
        this.borrowerRepo = borrowerRepo;
        this.calculator = calculator;
    }

    @Transactional
    public CreditProfile createOrUpdate(
            Long borrowerId,
            int monthlyIncome,
            int existingEmis,
            int activeLoans,
            int missedPayments) {

        Borrower borrower = borrowerRepo.findById(borrowerId)
                .orElseThrow(() -> new RuntimeException("Borrower not found"));

        CreditProfile profile = creditProfileRepo
                .findByBorrowerId(borrowerId)
                .orElse(CreditProfile.builder()
                        .borrower(borrower)
                        .build());

        profile.setMonthlyIncome(monthlyIncome);
        profile.setExistingEmis(existingEmis);
        profile.setActiveLoans(activeLoans);
        profile.setMissedPaymentsLast6Months(missedPayments);

        int score = calculator.calculate(profile);
        profile.setCreditScore(score);

        return creditProfileRepo.save(profile);
    }
}
