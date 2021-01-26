package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
