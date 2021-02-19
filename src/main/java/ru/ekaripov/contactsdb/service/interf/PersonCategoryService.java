package ru.ekaripov.contactsdb.service.interf;

import ru.ekaripov.contactsdb.model.PersonCategory;

import java.util.List;
import java.util.Optional;

public interface PersonCategoryService {
    PersonCategory addPersonCategory(PersonCategory personCategory);
    PersonCategory updatePersonCategory(PersonCategory personCategory);
    void deleteById(Long id);
    List<PersonCategory> getAllPersonCategory();
    Optional<PersonCategory> findById(Long id);
}
