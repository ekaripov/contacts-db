package ru.ekaripov.contactsdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ekaripov.contactsdb.entities.Person;
import ru.ekaripov.contactsdb.entities.User;
import ru.ekaripov.contactsdb.model.EventType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    private Long id;

    private Date eventDate;

    private String description;

    private Person person;

    private User user;

    private EventType eventType;
}
