package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.HistoryType;
import ru.ekaripov.contactsdb.repository.HistoryTypeRepository;
import ru.ekaripov.contactsdb.service.interf.HistoryTypeService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HistoryTypeServiceImpl implements HistoryTypeService {

    private final HistoryTypeRepository repository;

    @Override
    @Transactional
    public HistoryType updateHistoryType(HistoryType historyType) {
        if(historyType.getId() == null) throw new IdNotDefinedException();
        HistoryType editHistoryType = repository.findById(historyType.getId()).orElseThrow(DatabaseEntryNotFoundException::new);
        editHistoryType.setTitle(historyType.getTitle());
        repository.save(editHistoryType);
        return editHistoryType;
    }

    @Override
    public List<HistoryType> getAllHistoryTypes() {
        return repository.findAll();
    }

    @Override
    public Optional<HistoryType> getHistoryTypeById(Long id) {
        return repository.findById(id);
    }
}
