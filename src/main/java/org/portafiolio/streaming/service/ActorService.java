package org.portafiolio.streaming.service;

import org.portafiolio.streaming.exeption.ResourceNotFoundException;
import org.portafiolio.streaming.model.Actor;
import org.portafiolio.streaming.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ActorService {
    private final ActorRepository actorRepository;
    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    
    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }
    public Actor getUserById(Long id){
        return actorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Actor resource not found"));
    }
    public Actor createActor(Actor actor){
        return actorRepository.save(actor);
    }
    public Actor updateActor(long id, Actor actor){
        Actor existingActor = getUserById(id);
        existingActor.setName(actor.getName());
        existingActor.setLastName(actor.getLastName());
        
        return actorRepository.save(existingActor);
    }
    public void deleteActorById(Long id){
        actorRepository.deleteById(id);
    }
}
