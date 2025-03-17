package com.example.crawler.service;

import com.example.crawler.model.CrawledPage;
import com.example.crawler.repository.CrawledPageRepository;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Optional;

@Service
public class WebCrawlerService {
    @Autowired
    private CrawledPageRepository crawledPageRepository;

    // Extract the HTML from a page using the url
    public String fetchPageContent(String url) {
        try {
            // Check if it already exists in Elasticsearch
            Optional<CrawledPage> page = Optional.ofNullable(crawledPageRepository.findByUrl(url));
            if (page.isPresent()) {
                return "Already indexed: " + url + "\n";
            }

            Document document = Jsoup.connect(url).get();
            String content = document.text();

            // Save to Elasticsearch
            CrawledPage savedPage = new CrawledPage(url, content);
            crawledPageRepository.save(savedPage);

            return "Crawled and stored: " + url + "\n";
        } catch(IOException e) {
            e.printStackTrace();
            return "Error fetching content" + e.getMessage() + "\n";
        }
    }
}
