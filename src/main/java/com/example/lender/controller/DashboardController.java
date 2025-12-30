package com.example.lender.controller;

import com.example.lender.repository.LoanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final LoanRepository loanRepository;

    public DashboardController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @GetMapping
    public Map<String, Object> dashboard() {

        Map<String, Object> map = new HashMap<>();

        map.put("totalLoans", loanRepository.count());
        map.put("approvedLoans", loanRepository.countByStatus("APPROVED"));
        map.put("pendingLoans", loanRepository.countByStatus("PENDING"));
        map.put("rejectedLoans", loanRepository.countByStatus("REJECTED"));

        return map;
    }
}
