package com.example.agileproject.services.implimentation;

import com.example.agileproject.dao.AdminRepository;
import com.example.agileproject.entities.Admin;
import com.example.agileproject.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin login(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }
}
