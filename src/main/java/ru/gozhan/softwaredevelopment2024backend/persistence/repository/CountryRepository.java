package ru.gozhan.softwaredevelopment2024backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gozhan.softwaredevelopment2024backend.persistence.entity.CountryEntity;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
