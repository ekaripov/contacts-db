package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.HistoryType;

@Repository
public interface HistoryTypeRepository extends JpaRepository<HistoryType, Long> {
}
