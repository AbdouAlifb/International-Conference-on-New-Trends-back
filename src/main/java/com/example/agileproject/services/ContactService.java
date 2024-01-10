package com.example.agileproject.services;

import com.example.agileproject.entities.Contacts;

import java.util.List;

public interface ContactService {
    List<Contacts> getAllContacts();
    Contacts getContactById(Long id);
    Contacts saveContact(Contacts contact);
    Contacts updateContact(Contacts contact);
    void deleteContact(Long id);
}
