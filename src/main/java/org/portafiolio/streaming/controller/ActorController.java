package org.portafiolio.streaming.controller;


import org.portafiolio.streaming.model.Actor;
import org.portafiolio.streaming.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {
    private final ActorService actorService;
    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
    
    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        Actor actor = actorService.getUserById(id);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        Actor createdActor = actorService.createActor(actor);
        return new ResponseEntity<>(createdActor, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable Long id, @RequestBody Actor actor) {
        Actor updatedActor = actorService.updateActor(id, actor);
        return new ResponseEntity<>(updatedActor, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id){
        actorService.deleteActorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}