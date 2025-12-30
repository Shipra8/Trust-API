package com.example.lender.controller;

import com.example.lender.dto.request.LoanRequestDTO;
import com.example.lender.dto.response.LoanResponseDTO;
import com.example.lender.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    public LoanResponseDTO create(@RequestBody LoanRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<LoanResponseDTO> getAll() {
        return service.getAll();
    }
}
