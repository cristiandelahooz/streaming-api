package org.portafiolio.streaming.service;

import org.portafiolio.streaming.exeption.ResourceNotFoundException;
import org.portafiolio.streaming.model.Content;
import org.portafiolio.streaming.model.report.Top10ContentReport;
import org.portafiolio.streaming.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;


@Service
public class ContentService {
    private final ContentRepository contentRepository;
    
    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }
    
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }
    
    public Content getContentById(Long id) {
        return contentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Content resource not found"));
    }
    
    public Content createContent(Content content) {
        return contentRepository.save(content);
    }
    
    public Content updateContent(Long id, Content content) {
        Content existingContent = getContentById(id);
        existingContent.setReleaseDate(content.getReleaseDate());
        existingContent.setGenre(content.getGenre());
        existingContent.setTitle(content.getTitle());
        existingContent.setAvailable(content.isAvailable());
        existingContent.setRating(content.getRating());
        existingContent.setCountry(content.getCountry());
        existingContent.setSynopsis(content.getSynopsis());
        existingContent.setContentType(content.getContentType());
        
        return contentRepository.save(existingContent);
    }
    
    public void deleteContentById(Long id) {
        contentRepository.deleteById(id);
    }
    
    public List<Top10ContentReport> getTop10ContentsByTypeAndDate(String type, Date beginDate, Date endDate) {
        List<Content> contents = getAllContents()
                .stream()
                .filter(content -> content.getViewsByDate(beginDate, endDate) != 0 &&
                        content.getContentType().equalsIgnoreCase(type))
                .sorted(Comparator.comparingLong(content -> ((Content) content).getViewsByDate(beginDate, endDate)).reversed()).limit(10).toList();
        
        return contents.stream()
                .map(content -> new Top10ContentReport(
                        content.getContentType(),
                        content.getTitle(),
                        content.getSynopsis(),
                        String.valueOf(content.getReleaseDate().toLocalDate().getYear()),
                        content.getViewsByDate(beginDate, endDate)
                ))
                .toList();
    }
}
