package ru.ekaripov.contactsdb.model.converter.impl;

import ru.ekaripov.contactsdb.model.Person;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.PersonDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDtoConverter implements EntityDtoConverter<Person, PersonDto> {
    @Override
    public PersonDto convertToDto(Person entity) {
        return PersonDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .middleName(entity.getMiddleName())
                .lastName(entity.getLastName())
                .dateOfBirth(entity.getDateOfBirth())
                .organization(entity.getOrganization())
                .position(entity.getPosition())
                .build();
    }

    @Override
    public Person convertFromDto(PersonDto dto) {
        throw new UnsupportedOperationException("Conversion is not supported");
    }

    @Override
    public List<PersonDto> convertToDto(Collection<Person> entities) {
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person person : entities) {
            personDtoList.add(convertToDto(person));
        }
        return personDtoList;
    }
}
