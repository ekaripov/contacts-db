package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.History;

import java.util.List;

public interface HistoryService {
    History save(History history);

    List<History> getAllHistoryRecords();
}