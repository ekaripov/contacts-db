package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.Event;
import ru.ekaripov.contactsdb.model.Person;
import ru.ekaripov.contactsdb.repository.EventRepository;
import ru.ekaripov.contactsdb.service.interf.EventService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    @Transactional
    public Event addEvent(Event event) {
        return repository.save(event);
    }

    @Override
    @Transactional
    public Event updateEvent(Event event) {
        if (event.getId() == null) throw new IdNotDefinedException();
        Event editEvent = repository.findById(event.getId()).orElseThrow(DatabaseEntryNotFoundException::new);
        editEvent.setEventDate(event.getEventDate());
        editEvent.setEventType(event.getEventType());
        editEvent.setDescription(event.getDescription());
        editEvent.setPerson(event.getPerson());
        editEvent.setUser(event.getUser());
        return repository.save(editEvent);
    }

    @Override
    @Transactional
    public void deleteEventById(Long id) {
        repository.findById(id).orElseThrow(DatabaseEntryNotFoundException::new);
        repository.deleteById(id);
    }

    @Override
    public Optional<Event> findEventById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public List<Event> findEventsByPersonId(Long personId) {
        return repository.findByPerson(personId);
    }

    @Override
    public List<Event> findUpcomingEventsByDays(int days) {
        return repository.findUpcomingEventsByDays(days);
    }
}
