package com.example.kafka.service;

import com.example.crawler.service.WebCrawlerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private WebCrawlerService webCrawlerService;

    // Listens for urls-to-crawl and crawls a page when received, then stores into Elasticsearch
    @KafkaListener(topics = "urls-to-crawl", groupId = "crawler-group")
    public void consumeUrl(String url) {
        System.out.println("Crawling Url: " +url);
        String result = webCrawlerService.fetchPageContent(url);
        System.out.println(result);
    }
}