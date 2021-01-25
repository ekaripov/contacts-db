package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.History;

@Repository
public interface HistoryRepository extends  JpaRepository<History, Long>{
}
