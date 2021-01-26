package ru.ekaripov.contactsdb.api.v1;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ekaripov.contactsdb.model.User;
import ru.ekaripov.contactsdb.model.converter.impl.UserDtoConverter;
import ru.ekaripov.contactsdb.model.dto.UserDto;
import ru.ekaripov.contactsdb.service.interf.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final UserDtoConverter converter;

    @GetMapping("/getAll")
    @ApiOperation(value = "Метод возвращает всех зарегестрированных пользователей")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        List<UserDto> allUserDto = converter.convertToDto(allUsers);
        return ResponseEntity.ok(allUserDto);
    }
}
