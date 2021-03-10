package ru.ekaripov.contactsdb.api.v1;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.Event;
import ru.ekaripov.contactsdb.model.History;
import ru.ekaripov.contactsdb.model.converter.impl.HistoryDtoConverter;
import ru.ekaripov.contactsdb.model.dto.HistoryDto;
import ru.ekaripov.contactsdb.service.interf.HistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
@AllArgsConstructor
public class HistoryRestController {

    private final HistoryService service;

    private final HistoryDtoConverter converter;

    @GetMapping("/getAll")
    @ApiOperation(value = "Метод возвращает все записи журнала логирования")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "You are not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!!!"),
            @ApiResponse(code = 404, message = "Not found!!!")
    })
    public ResponseEntity<List<HistoryDto>> getAllHistoryRecords() {
        List<History> allHistoryRecords = service.getAllHistoryRecords();
        List<HistoryDto> historyDtos = converter.convertToDto(allHistoryRecords);
        return ResponseEntity.ok(historyDtos);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<HistoryDto>> findHistoryByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(converter.convertToDto(service.findHistoryByUserId(userId)));
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<HistoryDto>> findHistoryByPersonId(@PathVariable Long personId){
        return ResponseEntity.ok(converter.convertToDto(service.findHistoryByPersonId(personId)));
    }

    @PostMapping
    public ResponseEntity<HistoryDto> addHistory(@RequestBody History history){
        history.setId(null);
        return ResponseEntity.ok(converter.convertToDto(service.addHistory(history)));
    }

    @PostMapping("/event/{userId}")
    public ResponseEntity<HistoryDto> addHistoryFromEvent(@RequestBody Event event, @PathVariable Long userId){
        try{
            return ResponseEntity.ok(converter.convertToDto(service.addHistoryFromEvent(event, userId)));
        } catch (DatabaseEntryNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (IdNotDefinedException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
