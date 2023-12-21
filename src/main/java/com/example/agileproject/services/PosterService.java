package com.example.agileproject.services;

import com.example.agileproject.entities.Poster;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PosterService {
Poster savePoster(Poster poster);
List<Poster> getListPoster();
    Poster updatePoster(Long PosterId, Poster updatedProduit);
    void deletePosterById(Long id);
    Poster getPosterById( Long id);
}
