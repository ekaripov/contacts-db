package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.Event;
import ru.ekaripov.contactsdb.model.converter.impl.EventDtoConverter;
import ru.ekaripov.contactsdb.model.dto.EventDto;
import ru.ekaripov.contactsdb.service.interf.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor
public class EventRestController {

    private final EventService service;
    private final EventDtoConverter converter;
    private static final int DEFAULT_DAYS = 5;

    @GetMapping("/getAll")
    public ResponseEntity<List<EventDto>> getAllEvent() {
        return ResponseEntity.ok(converter.convertToDto(service.getAllEvents()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> findEventById(@PathVariable Long id){
        return service.findEventById(id)
                .map(event -> ResponseEntity.ok(converter.convertToDto(event)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = {"/upcoming", "/upcoming/{days}"})
    public ResponseEntity<List<EventDto>> findUpcomingEvents(@PathVariable(name = "days", required = false) Integer days){
        int upcomingDays = (days == null) ? DEFAULT_DAYS : days;
        return ResponseEntity.ok(converter.convertToDto(service.findUpcomingEventsByDays(upcomingDays)));
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<EventDto>> findEventsByPerson(@PathVariable(name="personId") Long personId){
        return ResponseEntity.ok(converter.convertToDto(service.findEventsByPersonId(personId)));
    }

    @PostMapping
    public ResponseEntity<EventDto> addEvent(@RequestBody Event event){
        event.setId(null);
        return ResponseEntity.ok(converter.convertToDto(service.addEvent(event)));
    }

    @PutMapping
    public  ResponseEntity<EventDto> updateEvent(@RequestBody Event event){
        try{
            return ResponseEntity.ok(converter.convertToDto(service.updateEvent(event)));
        } catch (DatabaseEntryNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (IdNotDefinedException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        try {
            service.deleteEventById(id);
            return ResponseEntity.ok().build();
        } catch (DatabaseEntryNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }


}
