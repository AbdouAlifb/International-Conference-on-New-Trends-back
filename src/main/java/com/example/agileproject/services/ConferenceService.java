package com.example.agileproject.services;

import com.example.agileproject.dao.ConferenceInfoRepository;
import com.example.agileproject.dao.DynamicContentRepository;
import com.example.agileproject.dao.NewsRepository;
import com.example.agileproject.entities.ConferenceInfo;
import com.example.agileproject.entities.DynamicContent;
import com.example.agileproject.entities.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {
    @Autowired
    private ConferenceInfoRepository conferenceInfoRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private DynamicContentRepository dynamicContentRepository;

    // ConferenceInfo CRUD Operations
    public ConferenceInfo createConferenceInfo(ConferenceInfo info) {
        return conferenceInfoRepository.save(info);
    }

    public List<ConferenceInfo> getAllConferenceInfo() {
        return conferenceInfoRepository.findAll();
    }

    public ConferenceInfo updateConferenceInfo(Long id, ConferenceInfo info) {
        info.setId(id);
        return conferenceInfoRepository.save(info);
    }

    public void deleteConferenceInfo(Long id) {
        conferenceInfoRepository.deleteById(id);
    }
    public ConferenceInfo getConferenceInfoById(Long id) {
        return conferenceInfoRepository.findById(id).orElse(null);
    }

    // News CRUD Operations
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News updateNews(Long id, News news) {
        news.setId(id);
        return newsRepository.save(news);
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    // DynamicContent CRUD Operations
    public DynamicContent createDynamicContent(DynamicContent content) {
        return dynamicContentRepository.save(content);
    }

    public List<DynamicContent> getAllDynamicContent() {
        return dynamicContentRepository.findAll();
    }

    public DynamicContent updateDynamicContent(Long id, DynamicContent content) {
        content.setId(id);
        return dynamicContentRepository.save(content);
    }

    public void deleteDynamicContent(Long id) {
        dynamicContentRepository.deleteById(id);
    }
}
