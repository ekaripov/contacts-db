package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.Event;
import ru.ekaripov.contactsdb.model.History;
import ru.ekaripov.contactsdb.model.User;
import ru.ekaripov.contactsdb.repository.EventRepository;
import ru.ekaripov.contactsdb.repository.HistoryRepository;
import ru.ekaripov.contactsdb.repository.UserRepository;
import ru.ekaripov.contactsdb.service.interf.HistoryService;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository repository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Override
    public History addHistory(History history) {
        return repository.save(history);
    }

    @Override
    public History addHistoryFromEvent(Event event, Long currentUserId) {
        if(event.getId() == null) throw new IdNotDefinedException();
        Event eventRef = eventRepository.findById(event.getId()).orElseThrow(DatabaseEntryNotFoundException::new);
        User currentUser = userRepository.findById(currentUserId).orElseThrow(DatabaseEntryNotFoundException::new);
        History newHistory = new History();
        newHistory.setHistoryDate(LocalDate.now());
        newHistory.setHistoryType(eventRef.getEventType().getHistoryType());
        newHistory.setDescription(eventRef.getDescription());
        newHistory.setPerson(eventRef.getPerson());
        newHistory.setUser(currentUser);
        eventRepository.deleteById(eventRef.getId());
        return repository.save(newHistory);
    }

    @Override
    public List<History> findHistoryByPersonId(Long userId) {
        return repository.findByPersonId(userId);
    }

    @Override
    public List<History> findHistoryByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<History> getAllHistoryRecords() {
        return repository.findAll();
    }
}