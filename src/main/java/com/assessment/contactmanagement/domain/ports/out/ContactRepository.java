package com.assessment.contactmanagement.domain.ports.out;

import com.assessment.contactmanagement.domain.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository {
    public List<Contact> getContacts();

    public Contact getContactByEmail(String email);

    public Contact createContact(Contact contact);

    public Contact updateContact(Contact contact);

    public boolean deleteContactByEmail(String email);

}
