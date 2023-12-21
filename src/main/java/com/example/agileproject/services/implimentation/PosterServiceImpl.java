package com.example.agileproject.services.implimentation;

import com.example.agileproject.dao.PosterRepository;
import com.example.agileproject.entities.Poster;

import com.example.agileproject.services.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PosterServiceImpl implements PosterService {
    @Autowired
    private PosterRepository posterRepository;

    @Override
    public Poster savePoster(Poster poster) {
        return posterRepository.save(poster);
    }

    @Override
    public List<Poster> getListPoster() {
        return posterRepository.findAll();
    }

    @Override
    public Poster updatePoster(Long PosterId, Poster updatedProduit) {
        Poster existingProduit = posterRepository.findById(PosterId)
                .orElseThrow(() -> new RuntimeException("Poster non trouvé avec l'ID : " + PosterId));

        // Mettre à jour les propriétés du produit existant
        existingProduit.setTitlePoster(updatedProduit.getTitlePoster());
        existingProduit.setDescriptionPoster(updatedProduit.getDescriptionPoster());
        existingProduit.setContentPoster(updatedProduit.getContentPoster());

        // Enregistrer le produit mis à jour dans la base de données
        return posterRepository.save(existingProduit);
    }

    @Override
    public void deletePosterById(Long id) {
       posterRepository.deleteById(id);
    }

    @Override
    public Poster getPosterById(Long id) {
        return posterRepository.findById(id).get();
    }
}
