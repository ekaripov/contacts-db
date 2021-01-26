package ru.ekaripov.contactsdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ekaripov.contactsdb.model.ContactType;
import ru.ekaripov.contactsdb.model.Person;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDto {
    private Long id;

    private String text;

    private String comment;

    private ContactType contactType;

    private Person person;
}
