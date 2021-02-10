package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.model.ContactType;
import ru.ekaripov.contactsdb.model.converter.impl.ContactTypeDtoConverter;
import ru.ekaripov.contactsdb.model.dto.ContactTypeDto;
import ru.ekaripov.contactsdb.service.interf.ContactTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contact/type")
@AllArgsConstructor
public class ContactTypeRestController {

    private final ContactTypeService contactTypeService;
    private final ContactTypeDtoConverter converter;

    @GetMapping("/getAll")
    public ResponseEntity<List<ContactTypeDto>> getAllContactTypes() {
        List<ContactType> contactTypeList = contactTypeService.getAllContactTypes();
        List<ContactTypeDto> contactTypeDtoList = converter.convertToDto(contactTypeList);
        return ResponseEntity.ok(contactTypeDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactTypeDto> getContactTypeById(@PathVariable Long id) {
        Optional<ContactType> contactTypeOptional = contactTypeService.getById(id);
        if (contactTypeOptional.isPresent())
            return ResponseEntity.ok(converter.convertToDto(contactTypeOptional.get()));
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ContactTypeDto> addContactType(@RequestBody ContactType contactType){
        return ResponseEntity.ok(converter.convertToDto(contactTypeService.addContactType(contactType)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactTypeById(@PathVariable Long id) {
        contactTypeService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ContactTypeDto> updateContactTypeById(@RequestBody ContactType contactType) {
        try {
            return ResponseEntity.ok(converter.convertToDto(contactTypeService.updateContactType(contactType)));
        } catch (DatabaseEntryNotFoundException entryNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }
}
