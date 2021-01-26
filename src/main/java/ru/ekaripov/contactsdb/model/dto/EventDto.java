package ru.ekaripov.contactsdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ekaripov.contactsdb.model.EventType;
import ru.ekaripov.contactsdb.model.Person;
import ru.ekaripov.contactsdb.model.User;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    private Long id;

    private LocalDate eventDate;

    private String description;

    private Person person;

    private User user;

    private EventType eventType;
}
