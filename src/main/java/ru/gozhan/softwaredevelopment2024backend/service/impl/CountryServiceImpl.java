package ru.gozhan.softwaredevelopment2024backend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gozhan.softwaredevelopment2024backend.dto.CountryDto;
import ru.gozhan.softwaredevelopment2024backend.exception.CountryNotFoundException;
import ru.gozhan.softwaredevelopment2024backend.persistence.entity.CountryEntity;
import ru.gozhan.softwaredevelopment2024backend.persistence.repository.CountryRepository;
import ru.gozhan.softwaredevelopment2024backend.service.CountryService;
import ru.gozhan.softwaredevelopment2024backend.utils.CountryMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    private final CountryMapper countryMapper;

    @Override
    public List<CountryDto> getAll() {
        log.info("Receiving all countries");
        return countryMapper.toDtoList(countryRepository.findAll());
    }

    @Override
    @Transactional
    public CountryDto save(CountryDto countryDto) {
        log.info("Saving country: {}", countryDto);
        return countryMapper.toDto(
                countryRepository.save(
                        countryMapper.toEntity(countryDto)
                )
        );
    }

    @Override
    @Transactional
    public CountryDto update(Long id, CountryDto countryDto) {
        log.info("Updating country with id = {}, {}", id, countryDto);
        Optional<CountryEntity> countryEntity = countryRepository.findById(id);
        if (countryEntity.isEmpty()) {
            throw new CountryNotFoundException();
        }

        CountryEntity savedEntity = countryEntity.map(c -> {
            c.setId(countryDto.id());
            c.setName(countryDto.name());
            return countryRepository.save(c);
        }).get();

        return countryMapper.toDto(savedEntity);
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        if (countryRepository.findById(id).isEmpty()) {
            throw new CountryNotFoundException();
        }
        countryRepository.deleteById(id);
        return id;
    }

}
