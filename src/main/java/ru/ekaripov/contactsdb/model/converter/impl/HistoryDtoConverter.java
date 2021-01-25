package ru.ekaripov.contactsdb.model.converter.impl;

import org.springframework.stereotype.Component;
import ru.ekaripov.contactsdb.model.History;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.HistoryDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Utility class which helps to convert {@link History}
 * into {@link HistoryDto} and HistoryDto to History
 */
@Component
public class HistoryDtoConverter implements EntityDtoConverter<History, HistoryDto> {
    /**
     * Method converts {@link History} в {@link HistoryDto}
     *
     * @param entity {@link History} as a method parameter
     * @return returns {@link HistoryDto}
     */
    @Override
    public HistoryDto convertToDto(History entity) {
        return HistoryDto.builder()
                .id(entity.getId())
                .historyDate(entity.getHistoryDate())
                .historyType(entity.getHistoryType())
                .description(entity.getDescription())
                .person(entity.getPerson())
                .user(entity.getUser())
                .build();
    }

    @Override
    public History convertFromDto(HistoryDto dto) {
        throw new UnsupportedOperationException("Converted is not supported");
    }

    /**
     * Method converts {@link Collection} of {@link History} entities
     * into a {@link List} of {@link HistoryDto} entities
     *
     * @param entities Collection of History entities
     * @return returns List of HistoryDto entities
     */
    @Override
    public List<HistoryDto> convertToDto(Collection<History> entities) {
        List<HistoryDto> historyListDto = new ArrayList<>();
        for (History history : entities) {
            historyListDto.add(convertToDto(history));
        }
        return historyListDto;
    }
}
