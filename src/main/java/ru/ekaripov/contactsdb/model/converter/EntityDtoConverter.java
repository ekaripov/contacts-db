package ru.ekaripov.contactsdb.model.converter;

import ru.ekaripov.contactsdb.model.History;
import ru.ekaripov.contactsdb.model.dto.HistoryDto;

import java.util.Collection;
import java.util.List;
/**
 * Utility interface which helps to convert Entity into
 * DTO and DTO into Entity
 */
public interface EntityDtoConverter<E, D> {
    /**
     * Method converts Entity into DTO
     *
     * @param entity Entity to convert as a method parameter
     * @return returns DTO converted from Entity
     */
    D convertToDto(E entity);

    /**
     * Method converts DTO into Entity
     * @param dto instance of DTO
     * @return Entity converted from DTO
     */
    E convertFromDto(D dto);

    /**
     * Method converts Collection of Entities into List of DTO
     * @param entities {@link Collection} of Entities
     * @return {@link List} of DTO
     */
    List<D> convertToDto(Collection<E> entities);
}
