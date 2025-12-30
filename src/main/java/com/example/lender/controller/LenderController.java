package com.example.lender.controller;

import com.example.lender.dto.request.LenderRequestDTO;
import com.example.lender.dto.response.LenderResponseDTO;
import com.example.lender.service.LenderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lenders")
public class LenderController {

    private final LenderService lenderService;

    public LenderController(LenderService lenderService) {
        this.lenderService = lenderService;
    }

    // ✅ CREATE LENDER
    @PostMapping
    public LenderResponseDTO create(@RequestBody LenderRequestDTO dto) {
        return lenderService.create(dto);
    }

    // ✅ GET ALL LENDERS
    @GetMapping
    public List<LenderResponseDTO> getAll() {
        return lenderService.getAll();
    }
}
