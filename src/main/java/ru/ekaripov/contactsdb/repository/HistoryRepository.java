package ru.ekaripov.contactsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ekaripov.contactsdb.model.History;

import java.util.List;

@Repository
public interface HistoryRepository extends  JpaRepository<History, Long>{
    @Query(value = "SELECT * FROM history WHERE person_id = ?1", nativeQuery = true)
    List<History> findByPersonId(Long personId);

    @Query(value = "SELECT * FROM history WHERE user_id = ?1", nativeQuery = true)
    List<History> findByUserId(Long userId);
}
