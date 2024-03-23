package ru.gozhan.softwaredevelopment2024backend.service;

import ru.gozhan.softwaredevelopment2024backend.dto.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getAll();

    CountryDto save(CountryDto countryDto);

    CountryDto update(Long id, CountryDto countryDto);

    Long delete(Long id);

}
