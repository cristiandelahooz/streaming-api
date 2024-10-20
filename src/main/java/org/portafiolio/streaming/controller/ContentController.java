package org.portafiolio.streaming.controller;

import org.portafiolio.streaming.model.Content;
import org.portafiolio.streaming.model.report.Top10ContentReport;
import org.portafiolio.streaming.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;
@RestController
@RequestMapping("/api/v1/contents")
public class ContentController {
    
    private final ContentService contentService;
    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }
    
    @GetMapping
    public List<Content> getAllContents(){
        return contentService.getAllContents();
    }
    
    @GetMapping("/top10")
    public List<Top10ContentReport> getTop10ContentsByTypeAndDate(@RequestParam String type, @RequestParam Date beginDate, @RequestParam Date endDate){
        return contentService.getTop10ContentsByTypeAndDate(type, beginDate, endDate);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Long id){
        Content content = contentService.getContentById(id);
        return new ResponseEntity<>(content, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody Content content){
        Content createdContent = contentService.createContent(content);
        return new ResponseEntity<>(createdContent, HttpStatus.CREATED);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<Content> updateContent(@PathVariable Long id, @RequestBody Content content){
        Content updatedContent = contentService.updateContent(id, content);
        return new ResponseEntity<>(updatedContent, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id){
        contentService.deleteContentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
