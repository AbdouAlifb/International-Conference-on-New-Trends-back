package com.example.agileproject.web;

import com.example.agileproject.entities.Poster;

import com.example.agileproject.services.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/poster")
public class PosterController {
    @Autowired
    PosterService posterService;

    @PostMapping("/save")
    public Poster savePoster(@RequestBody Poster p) {
        return posterService.savePoster(p);
    }

    @GetMapping("/all")
    public List<Poster> getListOfPoster() {
        return posterService.getListPoster();
    }

    @GetMapping("/get/{id}")
    public Poster getPosterById(@PathVariable Long id) {
        return posterService.getPosterById(id);
    }

    @PutMapping("/update/{PosterId}")
    public Poster updatePoster(@PathVariable Long PosterId, @RequestBody Poster updatedProduit) {
        return posterService.updatePoster(PosterId, updatedProduit);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePosterById( @PathVariable Long id ){
        posterService.deletePosterById(id);
    }

}