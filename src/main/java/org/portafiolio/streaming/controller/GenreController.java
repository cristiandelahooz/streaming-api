package org.portafiolio.streaming.controller;

import org.portafiolio.streaming.model.Genre;
import org.portafiolio.streaming.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreController {
    private final GenreService genreService;
    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
    
    @GetMapping
    public List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable Long id){
        Genre genre = genreService.getGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre){
        Genre createdGenre = genreService.createGenre(genre);
        return new ResponseEntity<>(createdGenre, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genreDetails){
        Genre updatedGenre = genreService.updateGenre(id, genreDetails);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id){
        genreService.deleteGenreById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
