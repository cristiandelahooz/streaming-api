package org.portafiolio.streaming.controller;

import org.portafiolio.streaming.model.Language;
import org.portafiolio.streaming.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageController {
    private final LanguageService languageService;
    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping
    public List<Language> getAllLanguages(){
        return languageService.getAllLanguages();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Long id){
        Language language = languageService.getLanguageById(id);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Language> createLanguage(@RequestBody Language language){
        Language createdLanguage = languageService.createLanguage(language);
        return new ResponseEntity<>(createdLanguage, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Long id, @RequestBody Language language){
        Language updatedLanguage = languageService.updateLanguageById(id, language);
        return new ResponseEntity<>(updatedLanguage, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id){
        languageService.deleteLanguageById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
