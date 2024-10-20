package org.portafiolio.streaming.controller;

import org.portafiolio.streaming.model.Audiovisual;
import org.portafiolio.streaming.service.AudiovisualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/audiovisuals")
public class AudiovisualController {
    private final AudiovisualService audiovisualService;
    @Autowired
    public AudiovisualController(AudiovisualService audiovisualService) {
        this.audiovisualService = audiovisualService;
    }
    
    @GetMapping
    public List<Audiovisual> getAllAudiovisuals(){
        return audiovisualService.getAllAudiovisuals();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Audiovisual> getAudiovisualById(@PathVariable Long id){
        Audiovisual audiovisual = audiovisualService.getAudiovisualById(id);
        return new ResponseEntity<>(audiovisual, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Audiovisual> createAudiovisual(@RequestBody Audiovisual audiovisual){
        Audiovisual createdAudiovisual = audiovisualService.createAudiovisual(audiovisual);
        return new ResponseEntity<>(createdAudiovisual, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Audiovisual> updateAudiovisual(@PathVariable Long id, @RequestBody Audiovisual audiovisual){
        Audiovisual updatedAudiovisual = audiovisualService.updateAudiovisual(id, audiovisual);
        return new ResponseEntity<>(updatedAudiovisual, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudiovisual(@PathVariable Long id){
        audiovisualService.deleteAudiovisualById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
