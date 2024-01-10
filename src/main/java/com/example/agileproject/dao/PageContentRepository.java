package com.example.agileproject.dao;

import com.example.agileproject.entities.PageContent;
import com.example.agileproject.entities.PageType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageContentRepository extends JpaRepository<PageContent, Long> {
    List<PageContent> findByPageType(PageType pageType);
}
