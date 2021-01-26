package ru.ekaripov.contactsdb.model.converter.impl;

import org.springframework.stereotype.Component;
import ru.ekaripov.contactsdb.model.User;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.UserDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDtoConverter implements EntityDtoConverter<User, UserDto> {
    @Override
    public UserDto convertToDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .fullName(entity.getFullName())
                .authorities(entity.getAuthorities())
                .enabled(entity.isEnabled())
                .build();
    }

    @Override
    public User convertFromDto(UserDto dto) {
        throw new UnsupportedOperationException("Converted is not supported");
    }

    @Override
    public List<UserDto> convertToDto(Collection<User> entities) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : entities){
            userDtoList.add(convertToDto(user));
        }
        return userDtoList;
    }
}
