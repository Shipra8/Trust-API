package com.example.lender.controller;


import com.example.lender.entity.AdminUser;
import com.example.lender.service.AdminUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminUserService service;

    public AdminController(AdminUserService service) {
        this.service = service;
    }

    @PostMapping
    public AdminUser create(@RequestBody AdminUser admin) {
        return service.createAdmin(admin);
    }

    @GetMapping
    public List<AdminUser> getAll() {
        return service.getAllAdmins();
    }
}
