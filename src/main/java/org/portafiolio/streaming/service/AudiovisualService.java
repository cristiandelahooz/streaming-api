package org.portafiolio.streaming.service;

import org.portafiolio.streaming.exeption.ResourceNotFoundException;
import org.portafiolio.streaming.model.Audiovisual;
import org.portafiolio.streaming.repository.AudiovisualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.*;
@Service
public class AudiovisualService {
    private final AudiovisualRepository audiovisualRepository;
    @Autowired
    public AudiovisualService(AudiovisualRepository audiovisualRepository) {
        this.audiovisualRepository = audiovisualRepository;
    }
    
    public List<Audiovisual> getAllAudiovisuals(){
        return audiovisualRepository.findAll();
    }
    public Audiovisual getAudiovisualById(Long id){
        return audiovisualRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Audiovisual resource not found"));
    }
    public Audiovisual createAudiovisual(Audiovisual audiovisual){
        return audiovisualRepository.save(audiovisual);
    }
    public Audiovisual updateAudiovisual(Long id, Audiovisual audiovisual){
        Audiovisual existingAudiovisual = getAudiovisualById(id);
        existingAudiovisual.setSeason(audiovisual.getSeason());
        existingAudiovisual.setDuration(audiovisual.getDuration());
        existingAudiovisual.setName(audiovisual.getName());
        
        return audiovisualRepository.save(existingAudiovisual);
    }
    public void deleteAudiovisualById(Long id){
        audiovisualRepository.deleteById(id);
    }
}
