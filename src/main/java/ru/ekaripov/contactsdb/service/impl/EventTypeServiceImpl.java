package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.EventType;
import ru.ekaripov.contactsdb.model.HistoryType;
import ru.ekaripov.contactsdb.repository.EventTypeRepository;
import ru.ekaripov.contactsdb.repository.HistoryTypeRepository;
import ru.ekaripov.contactsdb.service.interf.EventTypeService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventTypeServiceImpl implements EventTypeService {

    private final EventTypeRepository repository;
    private final HistoryTypeRepository historyTypeRepository;

    @Override
    @Transactional
    public EventType addEventType(EventType eventType) {
        HistoryType historyType = new HistoryType();
        historyType.setTitle(eventType.getTitle());
        historyType.setShowInList(true);
        HistoryType savedHistoryType = historyTypeRepository.save(historyType);
        eventType.setShowInList(savedHistoryType.isShowInList());
        eventType.setHistoryType(savedHistoryType);
        return repository.save(eventType);
    }

    @Override
    @Transactional
    public EventType updateEventType(EventType eventType) {
        if (eventType.getId() == null) throw new IdNotDefinedException();
        EventType editEventType = repository.findById(eventType.getId()).orElseThrow(DatabaseEntryNotFoundException::new);
        HistoryType historyType = historyTypeRepository.findById(editEventType.getHistoryType().getId()).orElseThrow(DatabaseEntryNotFoundException::new);
        editEventType.setTitle(eventType.getTitle());
        historyType.setTitle(editEventType.getTitle());
        historyTypeRepository.save(historyType);
        return repository.save(editEventType);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).orElseThrow(DatabaseEntryNotFoundException::new);
        repository.deleteById(id);
    }

    @Override
    public Optional<EventType> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<EventType> getAll() {
        return repository.findAll();
    }
}
