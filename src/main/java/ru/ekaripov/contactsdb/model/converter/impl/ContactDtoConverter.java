package ru.ekaripov.contactsdb.model.converter.impl;

import org.springframework.stereotype.Component;
import ru.ekaripov.contactsdb.model.Contact;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.ContactDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ContactDtoConverter implements EntityDtoConverter<Contact, ContactDto> {
    @Override
    public ContactDto convertToDto(Contact entity) {
        return ContactDto.builder()
                .id(entity.getId())
                .text(entity.getText())
                .comment(entity.getComment())
                .contactType(entity.getContactType())
                .person(entity.getPerson())
                .build();
    }

    @Override
    public Contact convertFromDto(ContactDto dto) {
        throw new UnsupportedOperationException("Converted is not supported");
    }

    @Override
    public List<ContactDto> convertToDto(Collection<Contact> entities) {
        List<ContactDto> contactDtoList = new ArrayList<>();
        for (Contact contact : entities){
            contactDtoList.add(convertToDto(contact));
        }
        return contactDtoList;
    }
}
