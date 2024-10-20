package org.portafiolio.streaming.service;
import org.portafiolio.streaming.exeption.ResourceNotFoundException;
import org.portafiolio.streaming.model.Country;
import org.portafiolio.streaming.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }
    public Country getCountryById(Long id){
        return countryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country resource not found"));
    }
    public Country createCountry(Country country){
        return countryRepository.save(country);
    }
    public Country updateCountry(Long id, Country countryDetails){
        Country existingCountry = getCountryById(id);
        existingCountry.setName(countryDetails.getName());
        existingCountry.setDescription(countryDetails.getDescription());
        
        return countryRepository.save(existingCountry);
    }
    public void deleteCountryById(Long id){
        countryRepository.deleteById(id);
    }
}
