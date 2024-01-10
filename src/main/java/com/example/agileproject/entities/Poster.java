package com.example.agileproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Poster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;
   private String titlePoster;
   private String descriptionPoster;
   private String contentPoster;
}
