package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ekaripov.contactsdb.model.History;
import ru.ekaripov.contactsdb.repository.HistoryRepository;
import ru.ekaripov.contactsdb.service.interf.HistoryService;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    public History save(History history) {
        return historyRepository.save(history);
    }

    public List<History> getAllHistoryRecords() {
        return historyRepository.findAll();
    }
}