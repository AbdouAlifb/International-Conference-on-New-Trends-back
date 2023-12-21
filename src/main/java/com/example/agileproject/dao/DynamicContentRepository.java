package com.example.agileproject.dao;

import com.example.agileproject.entities.DynamicContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DynamicContentRepository extends JpaRepository<DynamicContent, Long> {}