package com.example.agileproject.dao;

import com.example.agileproject.entities.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contacts, Long> {
}
