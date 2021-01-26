package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUserByUsername(String username);

    User save(User user);

    List<User> getAllUsers();

}
