package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByDeletedIsNull();
    List<Person> findByDeletedIsNotNull();
    @Query("select p from Person p where (p.firstName like ?1) or (p.lastName like ?1) or (p.middleName like ?1)")
    List<Person> findBySearchString(String searchString);
}
