package com.example.agileproject.services;

import com.example.agileproject.dao.ContactRepository;
import com.example.agileproject.entities.Contacts;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public List<Contacts> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contacts getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact non trouvé avec l'ID : " + id));
    }


    @Override
    public Contacts saveContact(Contacts contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contacts updateContact(Contacts contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
