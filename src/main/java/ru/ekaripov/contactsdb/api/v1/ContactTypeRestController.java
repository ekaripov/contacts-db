package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ekaripov.contactsdb.model.ContactType;
import ru.ekaripov.contactsdb.model.converter.impl.ContactTypeDtoConverter;
import ru.ekaripov.contactsdb.model.dto.ContactTypeDto;
import ru.ekaripov.contactsdb.service.interf.ContactTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact/type")
@AllArgsConstructor
public class ContactTypeRestController {

    private final ContactTypeService contactTypeService;
    private final ContactTypeDtoConverter converter;

    @GetMapping("/getAll")
    public ResponseEntity<List<ContactTypeDto>> getAllContactTypes(){
        List<ContactType> contactTypeList = contactTypeService.getAllContactTypes();
        List<ContactTypeDto> contactTypeDtoList = converter.convertToDto(contactTypeList);
        return ResponseEntity.ok(contactTypeDtoList);
    }
}
