package com.example.agileproject.web;

import com.example.agileproject.entities.PageContent;
import com.example.agileproject.entities.PageType;
import com.example.agileproject.services.PageContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin // This enables CORS

@RestController
@RequestMapping("/api/content")
public class PageContentController {

    @Autowired
    private PageContentService service;

    @GetMapping
    public List<PageContent> getAllContent() {
        return service.getAllPageContent();
    }


    @PostMapping
    public PageContent addContent(@RequestBody PageContent content) {
        return service.savePageContent(content);
    }
    // In your PageContentController class

    @GetMapping("/by-id/{id}")
    public ResponseEntity<PageContent> getContentById(@PathVariable Long id) {
        return service.getPageContentById(id)
                .map(content -> new ResponseEntity<>(content, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/{pageType}")
    public List<PageContent> getContentByType(@PathVariable PageType pageType) {
        return service.getPageContentByType(pageType);
    }
    // In your PageContentController class

    @PutMapping("/{id}")
    public ResponseEntity<PageContent> updateContent(@PathVariable Long id, @RequestBody PageContent updatedContent) {
        return service.updatePageContent(id, updatedContent)
                .map(content -> new ResponseEntity<>(content, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContent(@PathVariable Long id) {
        boolean deleted = service.deletePageContent(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
