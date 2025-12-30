package com.example.lender.controller;

import com.example.lender.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username) {
        // TEMP SIMPLE LOGIN (no DB check yet)
        String token = jwtUtil.generateToken(username);
        return Map.of("token", token);
    }
}
