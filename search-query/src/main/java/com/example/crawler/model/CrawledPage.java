package com.example.crawler.model;

import java.lang.annotation.Inherited;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "webpages")
public class CrawledPage {
    @Id 
    private String id;
    private String url;
    private String content;

    public CrawledPage() {}

    public CrawledPage(String url, String content) {
        this.url = url;
        this.content = content;
    }

    public String getId(){ return id; }
    public void setId(String id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }


}

