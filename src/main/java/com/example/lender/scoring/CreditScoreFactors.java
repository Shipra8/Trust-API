package com.example.lender.scoring;

public class CreditScoreFactors {

    public static final int BASE_SCORE = 300;

    public static final int MAX_SCORE = 900;

    public static final int INCOME_WEIGHT = 2;
    public static final int EXPENSE_PENALTY = 1;
    public static final int EXISTING_LOAN_PENALTY = 30;
    public static final int DEFAULT_PENALTY = 150;

    private CreditScoreFactors() {}
}
