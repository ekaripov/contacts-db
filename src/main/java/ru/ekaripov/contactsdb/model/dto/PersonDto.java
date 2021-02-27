package ru.ekaripov.contactsdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {
    Long id;
    String firstName;
    String middleName;
    String lastName;
    LocalDate dateOfBirth;
    String organization;
    String position;
    PersonCategoryDto personCategory;
}
