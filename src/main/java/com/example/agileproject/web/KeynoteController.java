package com.example.agileproject.web;

import com.example.agileproject.entities.Keynote;

import com.example.agileproject.services.KeynoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/keynotes")
public class KeynoteController {

    @Autowired
    private KeynoteService keynoteService;


    @GetMapping("/all")
    public ResponseEntity<List<Keynote>> getAllKeynotes() {
        List<Keynote> keynotes = keynoteService.getAllKeynotes();
        return ResponseEntity.ok(keynotes);
    }


        @GetMapping("/{id}")
        public Keynote getKeynoteById(@PathVariable Long id) {
            Optional<Keynote> keynoteOptional = Optional.ofNullable(keynoteService.getKeynoteById(id));
            return keynoteOptional.orElse(null);
        }


    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Keynote> saveKeynote(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("bio") String bio,
            @RequestParam("content") String content
    ) {
        try {
            Keynote keynote = new Keynote();
            keynote.setTitle(title);
            keynote.setContent(content);
            keynote.setDescription(description);
            keynote.setBio(bio);
            keynote.setFilename(file.getOriginalFilename());
            keynote.setImage(file.getBytes());


            // Enregistrez l'entité Keynote dans la base de données
            Keynote savedKeynote = keynoteService.saveKeynote(keynote);
            return ResponseEntity.ok(savedKeynote);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Keynote> updateKeynote(
            @PathVariable Long id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("bio") String bio,
            @RequestParam("content") String content
    ) {
        try {
            // Retrieve the existing Keynote from the database
            Keynote existingKeynote = keynoteService.getKeynoteById(id);

            if (existingKeynote == null) {
                return ResponseEntity.notFound().build();
            }

            // Update the fields with new values
            existingKeynote.setTitle(title);
            existingKeynote.setContent(content);
            existingKeynote.setDescription(description);
            existingKeynote.setBio(bio);

            // Update the image only if a new file is provided
            if (file != null) {
                existingKeynote.setFilename(file.getOriginalFilename());
                existingKeynote.setImage(file.getBytes());
            }

            // Save the updated Keynote in the database
            Keynote updatedKeynote = keynoteService.saveKeynote(existingKeynote);
            return ResponseEntity.ok(updatedKeynote);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> deleteKeynote(@PathVariable Long id) {
        keynoteService.deleteKeynote(id);
        return ResponseEntity.ok("Keynote with id " + id + " deleted successfully.");
    }
}
