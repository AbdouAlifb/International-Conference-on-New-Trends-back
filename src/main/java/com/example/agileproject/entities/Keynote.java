package com.example.agileproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Keynote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String content;
    private String bio;
    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;


    @Column(name = "filename")
    private String filename;
}
