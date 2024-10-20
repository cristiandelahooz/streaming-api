package org.portafiolio.streaming.service;

import org.portafiolio.streaming.exeption.ResourceNotFoundException;
import org.portafiolio.streaming.model.Genre;
import org.portafiolio.streaming.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenreService {
    private final GenreRepository genreRepository;
    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
    
    public Genre getGenreById(Long id){
        return genreRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Genre resource not found"));
    }
    public Genre createGenre(Genre genre){
        return genreRepository.save(genre);
    }
    public Genre updateGenre(Long id, Genre genreDetails){
        Genre existingGenre = getGenreById(id);
        existingGenre.setAgeRating(genreDetails.getAgeRating());
        existingGenre.setDescription(genreDetails.getDescription());
        existingGenre.setDescription(genreDetails.getDescription());
        
        return genreRepository.save(existingGenre);
    }
    public void deleteGenreById(Long id){
        genreRepository.deleteById(id);
    }
}
