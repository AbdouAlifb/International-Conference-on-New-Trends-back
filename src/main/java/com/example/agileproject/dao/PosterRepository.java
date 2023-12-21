package com.example.agileproject.dao;

import com.example.agileproject.entities.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterRepository extends JpaRepository<Poster,Long> {

}
