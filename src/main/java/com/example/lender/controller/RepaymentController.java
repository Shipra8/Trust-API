package com.example.lender.controller;

import com.example.lender.dto.request.RepaymentRequestDTO;
import com.example.lender.dto.response.RepaymentResponseDTO;
import com.example.lender.service.RepaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repayments")
public class RepaymentController {

    private final RepaymentService service;

    public RepaymentController(RepaymentService service) {
        this.service = service;
    }

    @PostMapping
    public RepaymentResponseDTO pay(@RequestBody RepaymentRequestDTO dto) {
        return service.makePayment(dto);
    }

    @GetMapping("/loan/{id}")
    public List<RepaymentResponseDTO> getByLoan(@PathVariable Long id) {
        return service.getByLoan(id);
    }
}
