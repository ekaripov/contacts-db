package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ekaripov.contactsdb.model.Contact;
import ru.ekaripov.contactsdb.service.interf.ContactService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
@AllArgsConstructor
public class ContactRestController {

    private final ContactService contactService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> allContacts = contactService.getAllContacts();
        return ResponseEntity.ok(allContacts);
    }
}
