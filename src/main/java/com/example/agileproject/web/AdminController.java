package com.example.agileproject.web;

import com.example.agileproject.entities.Admin;
import com.example.agileproject.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/api/login")
    public String login(@RequestBody Admin admin) {
        Admin loggedInAdmin = adminService.login(admin.getEmail(), admin.getPassword());
        if (loggedInAdmin != null) {
            return "Login successful!";
        } else {
            return "Invalid credentials";
        }
    }
}
