package com.example.agileproject.services;

import com.example.agileproject.dao.KeynoteRepository;
import com.example.agileproject.entities.Keynote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeynoteServiceImpl implements KeynoteService{

    @Autowired
    private KeynoteRepository keynoteRepository;

    @Override
    public List<Keynote> getAllKeynotes() {
        return keynoteRepository.findAll();
    }

    @Override
    public Keynote getKeynoteById(Long id) {
        return keynoteRepository.findById(id).orElse(null);
    }

    @Override
    public Keynote saveKeynote(Keynote keynote) {
        return keynoteRepository.save(keynote);
    }

    @Override
    public void deleteKeynote(Long id) {
        keynoteRepository.deleteById(id);
    }


}
