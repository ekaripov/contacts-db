package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.ContactType;

import java.util.List;
import java.util.Optional;

public interface ContactTypeService {

    ContactType addContactType(ContactType contactType);

    ContactType updateContactType(ContactType contactType);

    List<ContactType> getAllContactTypes();

    void deleteById(Long id);

    Optional<ContactType> getById(Long id);

}
