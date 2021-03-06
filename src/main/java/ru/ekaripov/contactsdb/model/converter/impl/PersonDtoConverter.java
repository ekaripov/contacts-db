package ru.ekaripov.contactsdb.model.converter.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ekaripov.contactsdb.model.Person;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.PersonDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Component
@AllArgsConstructor
public class PersonDtoConverter implements EntityDtoConverter<Person, PersonDto> {
    private final PersonCategoryDtoConverter personCategoryDtoConverter;
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
                .personCategory(personCategoryDtoConverter.convertToDto(entity.getPersonCategory()))
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
