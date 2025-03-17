package com.example.crawler.repository;

import com.example.crawler.model.CrawledPage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

// Creates Elasticsearch Repository to store and query any crawled pages
@Repository
public interface CrawledPageRepository extends ElasticsearchRepository<CrawledPage, String> {
    CrawledPage findByUrl(String url);
}