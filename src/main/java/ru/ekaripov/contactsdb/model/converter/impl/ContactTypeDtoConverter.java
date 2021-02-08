package ru.ekaripov.contactsdb.model.converter.impl;

import org.springframework.stereotype.Component;
import ru.ekaripov.contactsdb.model.ContactType;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.ContactTypeDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ContactTypeDtoConverter implements EntityDtoConverter<ContactType, ContactTypeDto> {
    @Override
    public ContactTypeDto convertToDto(ContactType entity) {
        return ContactTypeDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }

    @Override
    public ContactType convertFromDto(ContactTypeDto dto) {
        throw new UnsupportedOperationException("Conversion is not supported");
    }

    @Override
    public List<ContactTypeDto> convertToDto(Collection<ContactType> entities) {
        List<ContactTypeDto> contactTypeDtoList = new ArrayList<>();
        for (ContactType contactType : entities){
            contactTypeDtoList.add(convertToDto(contactType));
        }
        return contactTypeDtoList;
    }
}
