package ru.gozhan.softwaredevelopment2024backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gozhan.softwaredevelopment2024backend.dto.CountryDto;
import ru.gozhan.softwaredevelopment2024backend.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<List<CountryDto>> getAll() {
        return ResponseEntity.ok(countryService.getAll());
    }

    @PostMapping("/countries")
    public ResponseEntity<CountryDto> postCountry(@RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.save(countryDto));
    }

    @PutMapping("/countries/{id}")
    public ResponseEntity<CountryDto> putCountry(@PathVariable Long id,
                                                 @RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.update(id, countryDto));
    }

    @DeleteMapping("/countries/{id}")
    public ResponseEntity<Long> deleteCountry(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.delete(id));
    }

}
