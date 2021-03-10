package ru.ekaripov.contactsdb.model.converter.impl;

import org.springframework.stereotype.Component;
import ru.ekaripov.contactsdb.model.EventType;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.EventTypeDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Component
public class EventTypeDtoConverter implements EntityDtoConverter<EventType, EventTypeDto> {
    @Override
    public EventTypeDto convertToDto(EventType entity) {
        return EventTypeDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }

    @Override
    public EventType convertFromDto(EventTypeDto dto) {
        throw new UnsupportedOperationException("Conversion is not supported");
    }

    @Override
    public List<EventTypeDto> convertToDto(Collection<EventType> entities) {
        List<EventTypeDto> dtoList = new ArrayList<>();
        for(EventType entity : entities){
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }
}
