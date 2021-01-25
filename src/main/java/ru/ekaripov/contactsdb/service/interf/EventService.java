package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.Event;

import java.util.List;

public interface EventService {
    Event save(Event event);

    List<Event> getAllEvents();
}
