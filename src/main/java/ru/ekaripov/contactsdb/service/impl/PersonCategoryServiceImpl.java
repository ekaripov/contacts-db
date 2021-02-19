package ru.ekaripov.contactsdb.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.PersonCategory;
import ru.ekaripov.contactsdb.repository.PersonCategoryRepository;
import ru.ekaripov.contactsdb.service.interf.PersonCategoryService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonCategoryServiceImpl implements PersonCategoryService {

    private final PersonCategoryRepository repository;

    @Override
    @Transactional
    public PersonCategory addPersonCategory(PersonCategory personCategory) {
        return repository.save(personCategory);
    }

    @Override
    @Transactional
    public PersonCategory updatePersonCategory(PersonCategory personCategory) {
        if (personCategory.getId() == null) throw new IdNotDefinedException();
        PersonCategory editPersonCategory = repository.findById(personCategory.getId()).orElseThrow(DatabaseEntryNotFoundException::new);
        editPersonCategory.setTitle(personCategory.getTitle());
        return repository.save(editPersonCategory);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).orElseThrow(DatabaseEntryNotFoundException::new);
        repository.deleteById(id);
    }

    @Override
    public List<PersonCategory> getAllPersonCategory() {
        return repository.findAll();
    }

    @Override
    public Optional<PersonCategory> findById(Long id) {
        return repository.findById(id);
    }
}
