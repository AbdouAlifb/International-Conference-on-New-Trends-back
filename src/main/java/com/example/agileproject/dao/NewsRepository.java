package com.example.agileproject.dao;

import com.example.agileproject.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {}
