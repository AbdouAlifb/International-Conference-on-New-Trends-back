package com.example.agileproject.web;

import com.example.agileproject.dto.ProgramDto;
import com.example.agileproject.entities.Program;
import com.example.agileproject.services.ProgramServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/program")
public class ProgramController  {
    @Autowired
    ProgramServiceInterface programServiceInterface ;

    @PostMapping("/create")
    public Program add(@RequestBody ProgramDto program) throws ParseException {
        // Assuming you have the startTimeString and endTimeString as strings in the format "HH:mm:ss"
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date parsedStartTime = sdf.parse(program.getStartTime());
        Time startTime = new Time(parsedStartTime.getTime());

        Date parsedEndTime = sdf.parse(program.getEndTime());
        Time endTime = new Time(parsedEndTime.getTime());

// Now, you can set these Time objects to your entity object and send it to the API
        return programServiceInterface.create(new Program(program.getId(),program.getName() ,program.getDate(), startTime , endTime , program.getDescription()));
    }

    private Program convertTimeFieldsToSqlTime(Program program) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date parsedStartTime = sdf.parse(program.getStartTime().toString());
        Time startTime = new Time(parsedStartTime.getTime());

        Date parsedEndTime = sdf.parse(program.getEndTime().toString());
        Time endTime = new Time(parsedEndTime.getTime());

        program.setStartTime(startTime);
        program.setEndTime(endTime);

        return program;
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
    public Program getById(@PathVariable Long id) {
        return programServiceInterface.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public  void delete(@PathVariable Long id){
        programServiceInterface.delete(id);
    }

}