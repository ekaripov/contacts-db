package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person addPerson(Person person);
    Person updatePerson(Person person);
    List<Person> getAllPerson();
    List<Person> findDeletedPerson();
    void deleteById(Long id);
    Optional<Person> findById(Long id);
    List<Person> findBySearchString(String searchString);
}
