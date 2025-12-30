package com.example.lender.service.credit;

import com.example.lender.entity.CreditProfile;
import org.springframework.stereotype.Component;

@Component
public class CreditScoreCalculator {

    /**
     * Score range: 300 – 900
     */
    public int calculate(CreditProfile profile) {

        int score = 600; // base score

        // Income impact
        if (profile.getMonthlyIncome() >= 100000) score += 100;
        else if (profile.getMonthlyIncome() >= 50000) score += 50;

        // EMI burden
        score -= profile.getExistingEmis() * 20;

        // Active loans
        score -= profile.getActiveLoans() * 30;

        // Missed payments (high weight)
        score -= profile.getMissedPaymentsLast6Months() * 50;

        // Clamp score
        return Math.max(300, Math.min(score, 900));
    }
}
