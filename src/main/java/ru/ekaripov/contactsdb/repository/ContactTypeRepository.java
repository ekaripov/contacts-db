package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.ContactType;

@Repository
public interface ContactTypeRepository extends JpaRepository<ContactType, Long> {
}
