package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ekaripov.contactsdb.model.ContactType;
import ru.ekaripov.contactsdb.repository.ContactTypeRepository;
import ru.ekaripov.contactsdb.service.interf.ContactTypeService;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactTypeServiceImpl implements ContactTypeService {

    private final ContactTypeRepository contactTypeRepository;

    @Override
    public ContactType save(ContactType contactType) {
        return contactTypeRepository.save(contactType);
    }

    @Override
    public List<ContactType> getAllContactTypes() {
        return contactTypeRepository.findAll();
    }
}
