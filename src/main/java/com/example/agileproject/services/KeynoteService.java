package com.example.agileproject.services;

import com.example.agileproject.entities.Keynote;

import java.util.List;

public interface KeynoteService {
    List<Keynote> getAllKeynotes();
    Keynote getKeynoteById(Long id);
    Keynote saveKeynote(Keynote keynote);
    void deleteKeynote(Long id);

}
