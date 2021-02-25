package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.HistoryType;

import java.util.List;
import java.util.Optional;

public interface HistoryTypeService {
    HistoryType updateHistoryType(HistoryType historyType);
    List<HistoryType> getAllHistoryTypes();
    Optional<HistoryType> getHistoryTypeById(Long id);
}
