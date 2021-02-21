package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByDeletedIsNull();
    List<Person> findByDeletedIsNotNull();

    @Query(value = "SELECT * FROM person WHERE (deleted IS NULL) AND " +
            "((LOWER(first_name) LIKE %?#{[0].toLowerCase()}%) OR " +
            "(LOWER(middle_name) LIKE %?#{[0].toLowerCase()}%) OR " +
            "(LOWER(last_name) LIKE %?#{[0].toLowerCase()}%) OR " +
            "(LOWER(organization) LIKE %?#{[0].toLowerCase()}%) OR " +
            "(LOWER(position) LIKE %?#{[0].toLowerCase()}%) OR " +
            "(LOWER(comment) LIKE %?#{[0].toLowerCase()}%))", nativeQuery = true)
    List<Person> findBySearchString(@Param("search") String searchString);
}
