package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.Event;
import ru.ekaripov.contactsdb.model.History;

import java.util.List;

public interface HistoryService {
    History addHistory(History history);

    History addHistoryFromEvent(Event event, Long currentUserId);

    List<History> findHistoryByPersonId(Long userId);

    List<History> findHistoryByUserId(Long userId);

    List<History> getAllHistoryRecords();
}