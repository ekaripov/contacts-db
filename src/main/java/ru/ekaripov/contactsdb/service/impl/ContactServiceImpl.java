package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.Contact;
import ru.ekaripov.contactsdb.repository.ContactRepository;
import ru.ekaripov.contactsdb.service.interf.ContactService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    @Transactional
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public Contact updateContact(Contact contact) {
        if(contact.getId() == null) throw new IdNotDefinedException();
        Contact editContact = contactRepository.findById(contact.getId()).orElseThrow(DatabaseEntryNotFoundException::new);
        editContact.setContactType(contact.getContactType());
        editContact.setText(contact.getText());
        editContact.setComment(contact.getComment());
        return contactRepository.save(editContact);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        contactRepository.findById(id).orElseThrow(DatabaseEntryNotFoundException::new);
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> findByPersonId(Long personId) {
        return contactRepository.findByPersonId(personId);
    }

    @Override
    public List<Contact> findByContactTypeId(Long id) {
        return contactRepository.findByContactTypeId(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
