package com.example.agileproject.web;

import com.example.agileproject.entities.Program;
import com.example.agileproject.services.ProgramServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/program")
public class ProgramController  {
    @Autowired
    ProgramServiceInterface programServiceInterface ;

    @PostMapping("/create")
    public Program add(@RequestBody Program program) {
        return programServiceInterface.create(program);
    }
    @GetMapping("/all")
    public List<Program> getall(){
        return programServiceInterface.getall();
    }
    @PutMapping("/update")
    public  Program update( @RequestParam Long id , @RequestBody Program program){
        return programServiceInterface.update(id,program);
    }
    @GetMapping("/{id}")
    public  Program getById(Long id )
    {
        return programServiceInterface.findById(id);
    }
    @DeleteMapping("/{id}")
    public  void delete(Long id){
        programServiceInterface.delete(id);
    }

}
