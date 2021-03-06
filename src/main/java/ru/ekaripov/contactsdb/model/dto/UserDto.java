package ru.ekaripov.contactsdb.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ekaripov.contactsdb.model.Authorities;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "DTO сущности User")
public class UserDto {
    private Long id;

    private String username;

    private String fullName;

    private boolean enabled;

    private Authorities authorities;
}
