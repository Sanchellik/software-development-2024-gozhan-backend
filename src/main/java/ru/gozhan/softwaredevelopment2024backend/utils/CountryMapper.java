package ru.gozhan.softwaredevelopment2024backend.utils;

import org.springframework.stereotype.Component;
import ru.gozhan.softwaredevelopment2024backend.dto.CountryDto;
import ru.gozhan.softwaredevelopment2024backend.persistence.entity.CountryEntity;

import java.util.List;

@Component
public class CountryMapper {

    public List<CountryDto> toDtoList(List<CountryEntity> countryEntityList) {
        return countryEntityList.stream().map(e -> new CountryDto(
                e.getId(),
                e.getName()
        )).toList();
    }

    public List<CountryEntity> toEntityList(List<CountryDto> countryDtoList) {
        return countryDtoList.stream().map(dto -> new CountryEntity(
                dto.id(),
                dto.name()
        )).toList();
    }

    public CountryDto toDto(CountryEntity countryEntity) {
        return new CountryDto(countryEntity.getId(), countryEntity.getName());
    }

    public CountryEntity toEntity(CountryDto countryDto) {
        return new CountryEntity(countryDto.id(), countryDto.name());
    }

}
