package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.web.bind.annotation.*;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.Contact;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.converter.impl.ContactDtoConverter;
import ru.ekaripov.contactsdb.model.dto.ContactDto;
import ru.ekaripov.contactsdb.service.interf.ContactService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contact")
@AllArgsConstructor
public class ContactRestController {

    private final ContactService contactService;
    private final ContactDtoConverter converter;

    @GetMapping("/getAll")
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<Contact> allContacts = contactService.getAllContacts();
        List<ContactDto> allContactDto = converter.convertToDto(allContacts);

        return ResponseEntity.ok(allContactDto);
    }

    @GetMapping("/person")
    public ResponseEntity<List<ContactDto>> findByPersonId(@RequestParam(name = "p") Long personId) {
        List<Contact> contactList = contactService.findByPersonId(personId);
        List<ContactDto> contactDtoList = converter.convertToDto(contactList);
        return ResponseEntity.ok(contactDtoList);
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> findByContactTypeId(@RequestParam(name = "c") Long contactTypeId) {
        List<Contact> contactList = contactService.findByContactTypeId(contactTypeId);
        List<ContactDto> contactDtoList = converter.convertToDto(contactList);
        return ResponseEntity.ok(contactDtoList);
    }

    @PostMapping
    public ResponseEntity<ContactDto> addContact(@RequestBody Contact contact) {
        contact.setId(null);
        Contact newContact = contactService.addContact(contact);
        ContactDto contactDto = converter.convertToDto(newContact);
        return ResponseEntity.ok(contactDto);
    }

    @PutMapping
    public ResponseEntity<ContactDto> updateContact(@RequestBody Contact contact) {
        try {
            Contact updatedContact = contactService.updateContact(contact);
            ContactDto contactDto = converter.convertToDto(updatedContact);
            return ResponseEntity.ok(contactDto);
        } catch (DatabaseEntryNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IdNotDefinedException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        try {
            contactService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DatabaseEntryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
