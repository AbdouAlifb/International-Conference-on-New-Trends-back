package com.example.agileproject.web;


import com.example.agileproject.entities.Contacts;
import com.example.agileproject.entities.Keynote;
import com.example.agileproject.services.ContactServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/contacts/")
public class ContactController {

    @Autowired
    ContactServiceImpl contactService;

    @GetMapping("/all")
    public ResponseEntity<List<Contacts>>  getAllContacts(){
        List<Contacts> contacts=contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public Contacts getContactById(@PathVariable Long id){
       Optional<Contacts> contactsOptional = Optional.ofNullable(contactService.getContactById(id));
       return contactsOptional.orElse(null);
    }

    @PostMapping("/add")
    public ResponseEntity<Contacts> saveContact(@RequestBody Contacts contacts){
            Contacts contact=contactService.saveContact(contacts);
            return ResponseEntity.ok(contact);
    }

    @PostMapping("/update")
    public ResponseEntity<Contacts> updateContact(@RequestBody Contacts contacts) {
        try {
            if (contacts.getId() == null) {
                throw new IllegalArgumentException("L'ID du contact ne peut pas être nul pour la mise à jour.");
            }

            Contacts existingContact = contactService.getContactById(contacts.getId());

            if (existingContact == null) {
                throw new EntityNotFoundException("Contact avec l'ID " + contacts.getId() + " introuvable pour la mise à jour.");
            }

            // Mettre à jour uniquement les champs qui ont été modifiés
            existingContact.setEmail(contacts.getEmail());
            existingContact.setAddress(contacts.getAddress());
            existingContact.setCityMap(contacts.getCityMap());

            Contacts updatedContact = contactService.updateContact(existingContact);

            return ResponseEntity.ok(updatedContact);
        } catch (Exception e) {
            // Gérer les erreurs, par exemple les erreurs de validation, de manière appropriée
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }   
}
