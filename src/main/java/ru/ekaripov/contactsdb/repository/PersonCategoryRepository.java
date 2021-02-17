package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.PersonCategory;

@Repository
public interface PersonCategoryRepository extends JpaRepository<PersonCategory, Long> {
}
