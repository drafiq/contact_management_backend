package com.assessment.contactmanagement.ui.controllers;

import com.assessment.contactmanagement.domain.models.Contact;
import com.assessment.contactmanagement.domain.ports.in.ContactService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        if (contacts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/contacts/find")
    public ResponseEntity<Contact> getContactByEmail(@RequestParam("email") String email) {
        Optional<Contact> contact = Optional.ofNullable(contactService.getContactByEmail(email));

        if (contact.isPresent()) {
            return new ResponseEntity<>(contact.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact newContact = contactService.createContact(new Contact(contact.getEmail(), contact.getName()));
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @PutMapping("/contacts")
    public ResponseEntity<Contact> updateContact(@RequestParam("email") String email, @RequestBody Contact contact) {
        Contact contactToUpdate = new Contact(email, contact.getName());
        Contact updatedContact = contactService.updateContact(contactToUpdate);
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);

    }

    @DeleteMapping("/contacts")
    public ResponseEntity<HttpStatus> deleteContact(@RequestParam("email") String email) {
        boolean isDeleted = contactService.deleteContactByEmail(email);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
