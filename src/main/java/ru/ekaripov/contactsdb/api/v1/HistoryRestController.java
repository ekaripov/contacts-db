package ru.ekaripov.contactsdb.api.v1;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ekaripov.contactsdb.model.History;
import ru.ekaripov.contactsdb.model.converter.impl.HistoryDtoConverter;
import ru.ekaripov.contactsdb.model.dto.HistoryDto;
import ru.ekaripov.contactsdb.service.interf.HistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
@AllArgsConstructor
public class HistoryRestController {

    private final HistoryService historyService;

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
        List<History> allHistoryRecords = historyService.getAllHistoryRecords();
        List<HistoryDto> historyDtos = converter.convertToDto(allHistoryRecords);
        return ResponseEntity.ok(historyDtos);
    }
}
