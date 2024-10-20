package org.portafiolio.streaming.service;

import org.portafiolio.streaming.exeption.ResourceNotFoundException;
import org.portafiolio.streaming.model.Language;
import org.portafiolio.streaming.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;
    
    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    public List<Language> getAllLanguages(){
        return languageRepository.findAll();
    }
    public Language getLanguageById(Long languageId){
        return languageRepository.findById(languageId).orElseThrow(()-> new ResourceNotFoundException("Language resource not found"));
    }
    public Language createLanguage(Language language){
        return languageRepository.save(language);
    }
    public Language updateLanguageById(Long languageId, Language languageDetails){
        Language existingLanguage = getLanguageById(languageId);
        existingLanguage.setName(languageDetails.getName());
        
        return languageRepository.save(existingLanguage);
    }
    public void deleteLanguageById(Long languageId){
        languageRepository.deleteById(languageId);
    }
}
