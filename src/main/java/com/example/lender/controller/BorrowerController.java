package com.example.lender.controller;

import com.example.lender.dto.request.BorrowerRequestDTO;
import com.example.lender.dto.response.BorrowerResponseDTO;
import com.example.lender.service.BorrowerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

    private final BorrowerService service;

    public BorrowerController(BorrowerService service) {
        this.service = service;
    }

    @PostMapping
    public BorrowerResponseDTO create(@RequestBody BorrowerRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<BorrowerResponseDTO> getAll() {
        return service.getAll();
    }
}
