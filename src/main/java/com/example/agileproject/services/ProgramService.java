package com.example.agileproject.services;

import com.example.agileproject.dao.ProgramRepository;
import com.example.agileproject.entities.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService implements  ProgramServiceInterface {
    @Autowired
    ProgramRepository programRepository;

    @Override
    public Program create(Program program) {
       return  programRepository.save(program);
    }

    @Override
    public List<Program> getall() {
        return programRepository.findAll();
    }

    @Override
    public Program update(Long id, Program newProgramData) {
        // Vérifier si le programme existe dans la base de données
        if (programRepository.existsById(id)) {
            Program existingProgram = programRepository.findById(id).orElse(null);
            if (existingProgram != null) {
                // Mettre à jour les champs de l'entité existante avec les nouvelles valeurs
                existingProgram.setName(newProgramData.getName());
                existingProgram.setDate(newProgramData.getDate());
                existingProgram.setDescription(newProgramData.getDescription());

                // Enregistrer et retourner l'entité mise à jour
                return programRepository.save(existingProgram);
            }
        }
        return null; // Retourner null si le programme n'existe pas ou s'il y a une erreur
    }


    @Override
    public void delete(Long id) {
      programRepository.deleteById(id);
    }

    @Override
    public Program findById(Long id) {
        return programRepository.findById(id).get();
    }
}
