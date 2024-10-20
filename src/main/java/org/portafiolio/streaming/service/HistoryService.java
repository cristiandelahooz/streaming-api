package org.portafiolio.streaming.service;

import org.portafiolio.streaming.exeption.ResourceNotFoundException;
import org.portafiolio.streaming.model.History;
import org.portafiolio.streaming.model.compositeprimarykey.HistoryPK;
import org.portafiolio.streaming.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;
    
    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }
    

    public List<History> getAllHistoriesByUser(Long userId) {
        return historyRepository.findAll()
                .stream().filter(history -> history.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());
    }
    public History getHistoryById(Long userId, Long audiovisualId, Date date){
        HistoryPK pk = new HistoryPK();
        return historyRepository.findById(pk)
                .orElseThrow(()-> new ResourceNotFoundException("HistoryResourceNotFound"));
    }
    public History createHistory(History history, Long userId){
        history.getUser().setUserId(userId);
        return historyRepository.save(history);
    }
    public History updateHistory(Long userId, Long audiovisualId, Date date, History historyDetails){
        History existingHistory = getHistoryById(userId, audiovisualId,date);
        existingHistory.setTimeWatched(historyDetails.getTimeWatched());
        
        return historyRepository.save(existingHistory);
    }
    public void deleteHistory(Long userId, Long audiovisualId, Date date){
        History historyToDelete = getHistoryById(userId, audiovisualId, date);
        historyRepository.delete(historyToDelete);
    }
    
    
}
