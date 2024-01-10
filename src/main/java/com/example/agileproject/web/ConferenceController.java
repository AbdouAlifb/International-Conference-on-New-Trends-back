package com.example.agileproject.web;

import com.example.agileproject.entities.ConferenceInfo;
import com.example.agileproject.entities.DynamicContent;
import com.example.agileproject.entities.News;
import com.example.agileproject.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin // This enables CORS
@RestController
@RequestMapping("/api")
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    // ConferenceInfo Endpoints
    @PostMapping("/conference-info")
    public ConferenceInfo createConferenceInfo(@RequestBody ConferenceInfo info) {
        return conferenceService.createConferenceInfo(info);
    }

    @GetMapping("/conference-info")
    public List<ConferenceInfo> getAllConferenceInfo() {
        return conferenceService.getAllConferenceInfo();
    }
// In ConferenceController class
@CrossOrigin
    @GetMapping("/conference-info/{id}")
    public ConferenceInfo getConferenceInfoById(@PathVariable Long id) {
        return conferenceService.getConferenceInfoById(id);
    }

    @PutMapping("/conference-info/{id}")
    public ConferenceInfo updateConferenceInfo(@PathVariable Long id, @RequestBody ConferenceInfo info) {
        return conferenceService.updateConferenceInfo(id, info);
    }

    @DeleteMapping("/conference-info/{id}")
    public ResponseEntity<?> deleteConferenceInfo(@PathVariable Long id) {
        conferenceService.deleteConferenceInfo(id);
        return ResponseEntity.ok().build();
    }

    // News Endpoints
    @PostMapping("/news")
    public News createNews(@RequestBody News news) {
        return conferenceService.createNews(news);
    }

    @GetMapping("/news")
    public List<News> getAllNews() {
        return conferenceService.getAllNews();
    }

    @PutMapping("/news/{id}")
    public News updateNews(@PathVariable Long id, @RequestBody News news) {
        return conferenceService.updateNews(id, news);
    }

    @DeleteMapping("/news/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        conferenceService.deleteNews(id);
        return ResponseEntity.ok().build();
    }

    // DynamicContent Endpoints
    @PostMapping("/dynamic-content")
    public DynamicContent createDynamicContent(@RequestBody DynamicContent content) {
        return conferenceService.createDynamicContent(content);
    }

    @GetMapping("/dynamic-content")
    public List<DynamicContent> getAllDynamicContent() {
        return conferenceService.getAllDynamicContent();
    }

    @PutMapping("/dynamic-content/{id}")
    public DynamicContent updateDynamicContent(@PathVariable Long id, @RequestBody DynamicContent content) {
        return conferenceService.updateDynamicContent(id, content);
    }

    @DeleteMapping("/dynamic-content/{id}")
    public ResponseEntity<?> deleteDynamicContent(@PathVariable Long id) {
        conferenceService.deleteDynamicContent(id);
        return ResponseEntity.ok().build();
    }
}
