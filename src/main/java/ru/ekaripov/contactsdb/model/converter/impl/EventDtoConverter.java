package ru.ekaripov.contactsdb.model.converter.impl;

import org.springframework.stereotype.Component;
import ru.ekaripov.contactsdb.model.Event;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.EventDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EventDtoConverter implements EntityDtoConverter<Event, EventDto> {
    @Override
    public EventDto convertToDto(Event entity) {
        return EventDto.builder()
                .id(entity.getId())
                .eventDate(entity.getEventDate())
                .eventType(entity.getEventType())
                .description(entity.getDescription())
                .user(entity.getUser())
                .person(entity.getPerson())
                .build();
    }

    @Override
    public Event convertFromDto(EventDto dto) {
        throw new UnsupportedOperationException("Converted is not supported");
    }

    @Override
    public List<EventDto> convertToDto(Collection<Event> entities) {
        List<EventDto> eventDtoList = new ArrayList<>();
        for (Event event : entities) {
            eventDtoList.add(convertToDto(event));
        }
        return eventDtoList;
    }
}
