package com.example.agileproject.services;

import com.example.agileproject.entities.Registration;

import java.util.List;
import java.util.Optional;

public interface RegistrationService {
    public Registration saveRegistration(Registration registration);
    public List<Registration> getAllRegistrations();
    public Optional<Registration> getRegistrationById(Long id);
    public void deleteRegistration(Long id);
}
