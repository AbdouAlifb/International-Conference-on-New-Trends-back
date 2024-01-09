package com.example.agileproject.services;

import com.example.agileproject.entities.Admin;

public interface AdminService {
    Admin login(String email, String password);
}
