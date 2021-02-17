package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    Contact addContact(Contact contact);

    Contact updateContact(Contact contact);

    void deleteById(Long id);

    List<Contact> findByPersonId(Long personId);

    List<Contact> findByContactTypeId(Long contactTypeId);

    List<Contact> getAllContacts();
}
