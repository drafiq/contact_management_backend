package com.assessment.contactmanagement.domain.ports.in;

import com.assessment.contactmanagement.domain.models.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getContacts();

    public Contact getContactByEmail(String email);

    public Contact createContact(Contact contact);

    public Contact updateContact(Contact contact);

    public boolean deleteContactByEmail(String email);

}
