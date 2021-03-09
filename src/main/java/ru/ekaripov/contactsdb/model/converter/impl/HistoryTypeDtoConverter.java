package ru.ekaripov.contactsdb.model.converter.impl;

import org.springframework.stereotype.Component;
import ru.ekaripov.contactsdb.model.HistoryType;
import ru.ekaripov.contactsdb.model.converter.EntityDtoConverter;
import ru.ekaripov.contactsdb.model.dto.HistoryTypeDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Component
public class HistoryTypeDtoConverter implements EntityDtoConverter<HistoryType, HistoryTypeDto> {
    @Override
    public HistoryTypeDto convertToDto(HistoryType entity) {
        return HistoryTypeDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }

    @Override
    public HistoryType convertFromDto(HistoryTypeDto dto) {
        throw new UnsupportedOperationException("Conversion is not supported");
    }

    @Override
    public List<HistoryTypeDto> convertToDto(Collection<HistoryType> entities) {
        List<HistoryTypeDto> dtoList = new ArrayList<>();
        for (HistoryType entity : entities){
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }
}
