package ru.ekaripov.contactsdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ekaripov.contactsdb.entities.Person;
import ru.ekaripov.contactsdb.entities.User;
import ru.ekaripov.contactsdb.model.HistoryType;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDto {
    private Long id;
    private String description;
    private Date historyDate;
    private User user;
    private Person person;
    private HistoryType historyType;
}
