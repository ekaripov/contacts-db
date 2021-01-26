package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ekaripov.contactsdb.model.Contact;
import ru.ekaripov.contactsdb.repository.ContactRepository;
import ru.ekaripov.contactsdb.service.interf.ContactService;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContactsByPersonId(Long id) {
        return contactRepository.getAllContactsByPersonId(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
