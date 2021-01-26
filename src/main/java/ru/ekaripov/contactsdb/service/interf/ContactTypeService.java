package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.ContactType;

import java.util.List;

public interface ContactTypeService {

    ContactType save(ContactType contactType);

    List<ContactType> getAllContactTypes();

}
