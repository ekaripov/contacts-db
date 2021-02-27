package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.HistoryType;
import ru.ekaripov.contactsdb.model.converter.impl.HistoryTypeDtoConverter;
import ru.ekaripov.contactsdb.model.dto.HistoryTypeDto;
import ru.ekaripov.contactsdb.service.interf.HistoryTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/history/type")
@AllArgsConstructor
public class HistoryTypeRestController {

    private final HistoryTypeService service;
    private final HistoryTypeDtoConverter converter;

    @GetMapping
    public ResponseEntity<List<HistoryTypeDto>> getAllHistoryType() {
        List<HistoryType> historyTypeList = service.getAllHistoryTypes();
        List<HistoryTypeDto> historyTypeDtoList = converter.convertToDto(historyTypeList);
        return ResponseEntity.ok(historyTypeDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryTypeDto> getHistoryTypeById(@PathVariable Long id) {
        Optional<HistoryType> historyTypeOptional = service.getById(id);
        if (historyTypeOptional.isPresent())
            return ResponseEntity.ok(converter.convertToDto(historyTypeOptional.get()));
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<HistoryTypeDto> updateHistoryType(@RequestBody HistoryType historyType) {
        try {
            return ResponseEntity.ok(converter.convertToDto(service.updateHistoryType(historyType)));
        } catch (DatabaseEntryNotFoundException entryNotFoundException) {
            return ResponseEntity.notFound().build();
        } catch (IdNotDefinedException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
