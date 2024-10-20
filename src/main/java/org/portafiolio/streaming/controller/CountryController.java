package org.portafiolio.streaming.controller;

import org.portafiolio.streaming.model.Country;
import org.portafiolio.streaming.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {
    private final CountryService countryService;
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id){
        Country country = countryService.getCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        Country createdCountry = countryService.createCountry(country);
        return new ResponseEntity<>(createdCountry, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country countryDetails){
        Country updatedCountry = countryService.updateCountry(id, countryDetails);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id){
        countryService.deleteCountryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
