package com.example.lender.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LenderRequestDTO {
    private String name;
    private String email;
    private Double availableCapital;
}
