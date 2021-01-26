package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.Contact;

import java.util.List;

public interface ContactService {
    Contact save(Contact contact);

    List<Contact> getAllContactsByPersonId(Long id);

    List<Contact> getAllContacts();
}
