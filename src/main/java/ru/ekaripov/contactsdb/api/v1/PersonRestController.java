package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.Person;
import ru.ekaripov.contactsdb.model.converter.impl.PersonDtoConverter;
import ru.ekaripov.contactsdb.model.dto.PersonDto;
import ru.ekaripov.contactsdb.service.interf.PersonService;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/person")
@AllArgsConstructor
public class PersonRestController {
    private final PersonService service;
    private final PersonDtoConverter converter;

    @GetMapping("/deleted")
    public ResponseEntity<List<PersonDto>> getAllDeletedPerson() {
        return ResponseEntity.ok(converter.convertToDto(service.findDeletedPerson()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable Long id) {
        return service.findById(id)
                .map(person -> ResponseEntity.ok(converter.convertToDto(person)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findBySearchString(@RequestParam(name = "s") Optional<String> searchString) {
        if (searchString.isEmpty()) return ResponseEntity.ok(converter.convertToDto(service.getAllPerson()));
        return ResponseEntity.ok(converter.convertToDto(service.findBySearchString(searchString.get())));
    }

    @PostMapping
    public ResponseEntity<PersonDto> addPerson(@RequestBody Person person) {
        person.setId(null);
        return ResponseEntity.ok(converter.convertToDto(service.addPerson(person)));
    }

    @PutMapping
    public ResponseEntity<PersonDto> updatePerson(@RequestBody Person person) {
        try {
            return ResponseEntity.ok(converter.convertToDto(service.updatePerson(person)));
        } catch (DatabaseEntryNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IdNotDefinedException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DatabaseEntryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
