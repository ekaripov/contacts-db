package ru.ekaripov.contactsdb.model.converter;

import java.util.Collection;
import java.util.List;

public interface EntityDtoConverter<E,D> {
    D convertToDto(E entity);

    E convertFromDto(D dto);

    List<D> convertToDto(Collection<E> entities);
}
