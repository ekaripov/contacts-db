package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.Event;
import ru.ekaripov.contactsdb.model.EventType;
import ru.ekaripov.contactsdb.model.Person;
import ru.ekaripov.contactsdb.model.User;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event addEvent(Event event);
    Event updateEvent(Event event);
    void deleteEventById(Long id);
    Optional<Event> findEventById(Long id);
    List<Event> getAllEvents();
    List<Event> findEventsByPerson(Person person);
    List<Event> findUpcomingEventsByDays(int days);
}
