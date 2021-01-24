package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {
}
