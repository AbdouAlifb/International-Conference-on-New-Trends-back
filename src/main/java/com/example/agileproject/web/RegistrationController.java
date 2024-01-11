package com.example.agileproject.web;

import com.example.agileproject.entities.Poster;
import com.example.agileproject.entities.Registration;
import com.example.agileproject.services.PosterService;
import com.example.agileproject.services.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    PosterService posterService;
    @Autowired
    private RegistrationServiceImpl registrationService;

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public Optional<Registration> getRegistrationById(@PathVariable Long id) {
        return registrationService.getRegistrationById(id);
    }

    @PostMapping
    public Registration saveRegistration(@RequestBody Registration registration) {
        return registrationService.saveRegistration(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
    }

    @PostMapping("/{id}/validate")
    public ResponseEntity<Void> validateRegistration(@PathVariable Long id) {
        try {
            // Find the registration to validate
            Registration registrationToValidate = registrationService.getRegistrationById(id)
                    .orElseThrow(() -> new Exception("Registration not found with id: " + id));

            // Perform any additional validation or business logic if needed

            // Create a new Poster using the attributes from the registration
            Poster newPoster = new Poster();
            newPoster.setTitlePoster(registrationToValidate.getTitre());  // Assuming name is used for titlePoster
            newPoster.setDescriptionPoster(registrationToValidate.getDescription());  // Assuming mail is used for descriptionPoster
            newPoster.setContentPoster("Mail :" +registrationToValidate.getMail()+"\n Name : "+registrationToValidate.getName()
            + " \n Content  :\n"+registrationToValidate.getCountry()
            );  // Assuming description is used for contentPoster

            // Save the new Poster
            posterService.savePoster(newPoster);

            // Remove the validated registration from registrations
            registrationService.deleteRegistration(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}