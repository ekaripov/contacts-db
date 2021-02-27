package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.EventType;
import ru.ekaripov.contactsdb.model.converter.impl.EventTypeDtoConverter;
import ru.ekaripov.contactsdb.model.dto.EventTypeDto;
import ru.ekaripov.contactsdb.service.interf.EventTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event/type")
@AllArgsConstructor
public class EventTypeRestController {
    private final EventTypeService service;
    private final EventTypeDtoConverter converter;

    @GetMapping
    public ResponseEntity<List<EventTypeDto>> getAllEventTypes(){
        return ResponseEntity.ok(converter.convertToDto(service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventTypeDto> getEventTypeById(@PathVariable Long id){
        return service.getById(id)
                .map(eventType -> ResponseEntity.ok(converter.convertToDto(eventType)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EventTypeDto> addEventType(@RequestBody EventType eventType){
        eventType.setId(null);
        return ResponseEntity.ok(converter.convertToDto(service.addEventType(eventType)));
    }

    @PutMapping
    public  ResponseEntity<EventTypeDto> updateEventType(@RequestBody EventType eventType){
        try{
            return ResponseEntity.ok(converter.convertToDto(service.updateEventType(eventType)));
        } catch (DatabaseEntryNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (IdNotDefinedException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventType(@PathVariable Long id){
        try{
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DatabaseEntryNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
