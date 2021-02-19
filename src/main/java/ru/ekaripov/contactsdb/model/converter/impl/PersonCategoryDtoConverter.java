package ru.ekaripov.contactsdb.model.converter.impl;

import org.springframework.stereotype.Component;
import ru.ekaripov.contactsdb.model.PersonCategory;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.PersonCategoryDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PersonCategoryDtoConverter implements EntityDtoConverter<PersonCategory, PersonCategoryDto> {

    @Override
    public PersonCategoryDto convertToDto(PersonCategory entity) {
        return PersonCategoryDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }

    @Override
    public PersonCategory convertFromDto(PersonCategoryDto dto) {
        throw new UnsupportedOperationException("Conversion is not supported");
    }

    @Override
    public List<PersonCategoryDto> convertToDto(Collection<PersonCategory> entities) {
        List<PersonCategoryDto> personCategoryDtoList = new ArrayList<>();
        for (PersonCategory personCategory : entities){
            personCategoryDtoList.add(convertToDto(personCategory));
        }
        return personCategoryDtoList;
    }
}
