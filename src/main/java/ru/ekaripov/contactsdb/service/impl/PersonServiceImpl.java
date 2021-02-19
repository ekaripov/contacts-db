package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.model.Person;
import ru.ekaripov.contactsdb.repository.PersonRepository;
import ru.ekaripov.contactsdb.service.interf.PersonService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    @Transactional
    public Person addPerson(Person person) {
        person.setCreated(LocalDate.now());
        person.setUpdated(LocalDate.now());
        return repository.save(person);
    }

    @Override
    @Transactional
    public Person updatePerson(Person person) {
        person.setUpdated(LocalDate.now());
        return repository.save(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return repository.findByDeletedIsNull();
    }

    @Override
    public List<Person> findDeletedPerson() {
        return repository.findByDeletedIsNotNull();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Person person = repository.findById(id).orElseThrow(DatabaseEntryNotFoundException::new);
        person.setUpdated(LocalDate.now());
        person.setDeleted(LocalDate.now());
        repository.save(person);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Person> findBySearchString(String searchString) {
        return repository.findBySearchString(searchString);
    }
}
