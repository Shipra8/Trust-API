package com.example.lender.controller;

import com.example.lender.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/loans")
public class AdminLoanController {

    private final LoanService loanService;

    public AdminLoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/{id}/approve")
    public void approve(@PathVariable Long id) {
        loanService.approveLoan(id);
    }

    @PostMapping("/{id}/reject")
    public void reject(@PathVariable Long id) {
        loanService.rejectLoan(id);
    }
}
