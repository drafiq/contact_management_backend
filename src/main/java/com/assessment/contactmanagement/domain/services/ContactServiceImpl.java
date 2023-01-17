package com.assessment.contactmanagement.domain.services;

import com.assessment.contactmanagement.domain.models.Contact;
import com.assessment.contactmanagement.domain.ports.in.ContactService;
import com.assessment.contactmanagement.domain.ports.out.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;
    @Override
    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }

    @Override
    public Contact getContactByEmail(String email) {
        return contactRepository.getContactByEmail(email);
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.createContact(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.updateContact(contact);
    }

    @Override
    public boolean deleteContactByEmail(String email) {
        return contactRepository.deleteContactByEmail(email);
    }
}
