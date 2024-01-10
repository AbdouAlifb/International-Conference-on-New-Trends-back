package com.example.agileproject.dao;

import com.example.agileproject.entities.ConferenceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceInfoRepository extends JpaRepository<ConferenceInfo, Long> {}