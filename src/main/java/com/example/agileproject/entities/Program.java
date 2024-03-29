package com.example.agileproject.entities;


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
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id ;
    private String name;
    private Date   date;
    private Time   startTime;
    private Time   endTime ;
    private String description ;


}
