package com.example.agileproject.services;

import com.example.agileproject.dao.PageContentRepository;
import com.example.agileproject.entities.PageContent;
import com.example.agileproject.entities.PageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageContentService {

    @Autowired
    private PageContentRepository repository;

    public PageContent savePageContent(PageContent content) {
        return repository.save(content);
    }

    public List<PageContent> getPageContentByType(PageType type) {
        return repository.findByPageType(type);
    }
    // In your PageContentService class

    public Optional<PageContent> updatePageContent(Long id, PageContent updatedContent) {
        return repository.findById(id).map(content -> {
            content.setTitle(updatedContent.getTitle());
            content.setContent(updatedContent.getContent());
            content.setPageType(updatedContent.getPageType());
            return repository.save(content);
        });
    }
    public List<PageContent> getAllPageContent() {
        return repository.findAll();
    }
// In your PageContentService class

    public Optional<PageContent> getPageContentById(Long id) {
        return repository.findById(id);
    }

    public boolean deletePageContent(Long id) {
        return repository.findById(id).map(content -> {
            repository.delete(content);
            return true;
        }).orElse(false);
    }

}
