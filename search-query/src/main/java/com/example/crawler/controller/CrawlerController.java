package com.example.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.crawler.service.WebCrawlerService;

@RestController
@RequestMapping("/crawl")
public class CrawlerController {
    @Autowired
    private WebCrawlerService crawlerService;

    @GetMapping
    public String crawl(@RequestParam String url) {
        return crawlerService.fetchPageContent(url);
    }
}