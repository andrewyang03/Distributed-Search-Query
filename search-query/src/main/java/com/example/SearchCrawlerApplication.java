package com.example.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableElasticsearchRepositories(basePackages = {"com.example.indexer.repository", "com.example.crawler.repository"})
public class SearchCrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchCrawlerApplication.class, args);
    }
}
