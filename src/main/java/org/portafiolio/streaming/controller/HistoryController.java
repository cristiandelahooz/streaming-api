package org.portafiolio.streaming.controller;

import org.portafiolio.streaming.model.History;
import org.portafiolio.streaming.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/users/{userId}/histories")
public class HistoryController {
    private final HistoryService historyService;
    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public List<History> getAllHistoryByUser(@PathVariable Long userId){
        return historyService.getAllHistoriesByUser(userId);
    }
    @GetMapping("/audiovisual/{audiovisualId}/date/{date}")
    public ResponseEntity<History> getHistoryById(@PathVariable Long userId, @PathVariable Long audiovisualId, @PathVariable Date date){
        History history = historyService.getHistoryById(userId, audiovisualId, date);
        return  new ResponseEntity<>(history, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<History> createHistory(@RequestBody History history, @PathVariable Long userId){
        History createdHistory = historyService.createHistory(history, userId);
        return new ResponseEntity<>(createdHistory, HttpStatus.CREATED);
    }
    @PutMapping("/audiovisual/{audiovisualId}/date/{date}")
    public ResponseEntity<History> updateHistory(@PathVariable Long userId, @PathVariable Long audiovisualId, @PathVariable Date date, @RequestBody History historyDetails){
        History updatedHistory = historyService.updateHistory(userId, audiovisualId, date, historyDetails);
        return new ResponseEntity<>(updatedHistory, HttpStatus.OK);
        
    }
    @DeleteMapping("/audiovisual/{audiovisualId}/date/{date}")
    public ResponseEntity<Void> deleteHistory(@PathVariable Long userId, @PathVariable Long audiovisualId, @PathVariable Date date){
        historyService.deleteHistory(userId, audiovisualId, date);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
