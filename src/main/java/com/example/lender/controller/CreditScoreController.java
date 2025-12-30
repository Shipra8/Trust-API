package com.example.lender.controller;

import com.example.lender.entity.CreditScore;
import com.example.lender.service.CreditScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-score")
public class CreditScoreController {

    private final CreditScoreService service;

    public CreditScoreController(CreditScoreService service) {
        this.service = service;
    }

    @PostMapping("/{borrowerId}")
    public CreditScore generate(@PathVariable Long borrowerId) {
        return service.generate(borrowerId);
    }
}
