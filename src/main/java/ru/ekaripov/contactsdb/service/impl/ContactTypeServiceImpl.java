package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.model.ContactType;
import ru.ekaripov.contactsdb.repository.ContactTypeRepository;
import ru.ekaripov.contactsdb.service.interf.ContactTypeService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactTypeServiceImpl implements ContactTypeService {

    private final ContactTypeRepository contactTypeRepository;

    @Override
    @Transactional
    public ContactType addContactType(ContactType contactType) {
        return contactTypeRepository.save(contactType);
    }

    @Override
    @Transactional
    public ContactType updateContactType(ContactType contactType) {
        ContactType editContactType = contactTypeRepository.findById(contactType.getId()).orElseThrow(DatabaseEntryNotFoundException::new);
        contactTypeRepository.save(editContactType);
        return editContactType;
    }

    @Override
    public List<ContactType> getAllContactTypes() {
        return contactTypeRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        contactTypeRepository.deleteById(id);
    }

    @Override
    public Optional<ContactType> getById(Long id){return contactTypeRepository.findById(id);}
}
