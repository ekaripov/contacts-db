package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ekaripov.contactsdb.exceptions.UserNotFoundException;
import ru.ekaripov.contactsdb.model.User;
import ru.ekaripov.contactsdb.repository.UserRepository;
import ru.ekaripov.contactsdb.service.interf.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow((UserNotFoundException::new));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
