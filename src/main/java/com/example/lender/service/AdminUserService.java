package com.example.lender.service;

import com.example.lender.entity.AdminUser;
import com.example.lender.repository.AdminUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {

    private final AdminUserRepository repository;

    public AdminUserService(AdminUserRepository repository) {
        this.repository = repository;
    }

    public AdminUser createAdmin(AdminUser admin) {
        return repository.save(admin);
    }

    public List<AdminUser> getAllAdmins() {
        return repository.findAll();
    }
}
