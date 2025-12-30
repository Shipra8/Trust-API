package com.example.lender.service;

import com.example.lender.dto.request.LenderRequestDTO;
import com.example.lender.dto.response.LenderResponseDTO;
import com.example.lender.entity.Lender;
import com.example.lender.repository.LenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LenderService {

    private final LenderRepository repo;

    public LenderService(LenderRepository repo) {
        this.repo = repo;
    }

    public LenderResponseDTO create(LenderRequestDTO dto) {
        Lender lender = new Lender();
        lender.setName(dto.getName());
        lender.setEmail(dto.getEmail());
        lender.setAvailableCapital(dto.getAvailableCapital());

        Lender saved = repo.save(lender);

        return toDto(saved);
    }

    // Fixed: Now returns List of DTOs, not entities
    public List<LenderResponseDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Helper method to convert Entity → DTO
    private LenderResponseDTO toDto(Lender lender) {
        LenderResponseDTO res = new LenderResponseDTO();
        res.setId(lender.getId());
        res.setName(lender.getName());
        res.setEmail(lender.getEmail());
        res.setAvailableCapital(lender.getAvailableCapital());
        return res;
    }
}