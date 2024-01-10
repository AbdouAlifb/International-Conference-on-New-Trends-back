package com.example.agileproject.entities;

import jakarta.persistence.*;

@Entity
public class PageContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Lob
    private String content;

    @Enumerated(EnumType.STRING)
    private PageType pageType;

    // Getters and Setters

    public PageContent(Long id, String title, String content, PageType pageType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pageType = pageType;
    }

    public PageContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PageType getPageType() {
        return pageType;
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
    }
}

