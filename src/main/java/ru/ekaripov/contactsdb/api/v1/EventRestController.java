package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ekaripov.contactsdb.model.converter.impl.EventDtoConverter;
import ru.ekaripov.contactsdb.model.dto.EventDto;
import ru.ekaripov.contactsdb.service.interf.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor
public class EventRestController {

    private final EventService eventService;
    private final EventDtoConverter eventDtoConverter;

    @GetMapping("/getAll")
    public ResponseEntity<List<EventDto>> getAllEvent() {
        List<EventDto> eventDtoList = eventDtoConverter.convertToDto(eventService.getAllEvents());
        return ResponseEntity.ok(eventDtoList);
    }
}
