package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.EventType;

import java.util.List;
import java.util.Optional;

public interface EventTypeService {
    EventType addEventType(EventType eventType);
    EventType updateEventType(EventType eventType);
    void deleteById(Long id);
    Optional<EventType> getById(Long id);
    List<EventType> getAll();
}
