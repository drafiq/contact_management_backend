package com.assessment.contactmanagement.infrastructure.postgres;

import com.assessment.contactmanagement.domain.models.Contact;
import com.assessment.contactmanagement.domain.ports.out.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
    @Autowired
    JpaRepository<Contact, String> jpaRepository;

    @Override
    public List<Contact> getContacts() {
        return jpaRepository.findAll();
    }

    @Override
    public Contact getContactByEmail(String email) {
        Optional<Contact> contact = jpaRepository.findById(email);
        return contact.isPresent() ? contact.get() : null;
    }

    @Override
    public Contact createContact(Contact contact) {
        return jpaRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return jpaRepository.save(contact);
    }

    @Override
    public boolean deleteContactByEmail(String email) {
        jpaRepository.deleteById(email);
        return this.getContactByEmail(email) == null;
    }
}
