package com.example.agileproject.dto;

import com.example.agileproject.entities.Program;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id ;
    private String name;
    private Date date;
    private String startTime;
    private String   endTime ;
    private String description ;
}
