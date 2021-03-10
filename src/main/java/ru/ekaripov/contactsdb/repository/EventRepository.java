package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.Event;
import ru.ekaripov.contactsdb.model.Person;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(value = "SELECT * FROM events WHERE person_id = ?1", nativeQuery = true)
    List<Event> findByPersonId(Long personId);

    @Query(value = "SELECT * FROM events WHERE event_date BETWEEN " +
            "(CURRENT_DATE - interval '1' day) AND" +
            "(CURRENT_DATE + interval '?1' day)",
            nativeQuery = true)
    List<Event> findUpcomingEventsByDays(int days);
}
