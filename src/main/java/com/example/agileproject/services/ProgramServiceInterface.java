package com.example.agileproject.services;

import com.example.agileproject.entities.Program;

import java.util.List;

public interface ProgramServiceInterface {
    public Program create(Program program);
    public List<Program> getall();
    public Program update(Long id , Program program);
    public void delete(Long id );
    public Program findById(Long id);

}
