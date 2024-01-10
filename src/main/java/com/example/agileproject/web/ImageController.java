package com.example.agileproject.web;

import com.example.agileproject.dao.ImageRepository;
import com.example.agileproject.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/images")
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;

    // Get all images
    @GetMapping
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    // Get image by ID
    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        return optionalImage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new image
    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file,
                                             @RequestParam("date") String dateString) throws IOException, ParseException {
        // Convertir la date de la chaîne en objet Date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateString);

        // Créer une nouvelle instance d'Image
        Image image = new Image();
        image.setDate(date);
        image.setFilename(file.getOriginalFilename());
        image.setImage(file.getBytes());

        // Enregistrer l'image dans la base de données
        Image savedImage = imageRepository.save(image);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedImage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id,
                                             @RequestParam(value = "file", required = false) MultipartFile file,
                                             @RequestParam("date") String dateString) throws IOException, ParseException {
        Optional<Image> optionalImage = imageRepository.findById(id);

        if (optionalImage.isPresent()) {
            Image existingImage = optionalImage.get();

            // Mettez à jour la date si elle est fournie
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(dateString);
            existingImage.setDate(date);

            // Mettez à jour l'image uniquement si un nouveau fichier est fourni
            if (file != null && !file.isEmpty()) {
                existingImage.setFilename(file.getOriginalFilename());
                existingImage.setImage(file.getBytes());
            }

            // Enregistrez l'image mise à jour dans la base de données
            Image updatedImage = imageRepository.save(existingImage);

            return ResponseEntity.ok(updatedImage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Delete image by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        if (imageRepository.existsById(id)) {
            imageRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Display image by ID
    @GetMapping("/display/{id}")
    public ResponseEntity<byte[]> displayImage(@PathVariable Long id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Adjust based on your image type
            return new ResponseEntity<>(image.getImage(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
