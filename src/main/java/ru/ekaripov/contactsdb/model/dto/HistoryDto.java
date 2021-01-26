package ru.ekaripov.contactsdb.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ekaripov.contactsdb.model.HistoryType;
import ru.ekaripov.contactsdb.model.Person;
import ru.ekaripov.contactsdb.model.User;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "DTO для отображения журнала логирования")
public class HistoryDto {
    private Long id;
    private String description;
    private LocalDate historyDate;
    private User user;
    private Person person;
    private HistoryType historyType;
}
