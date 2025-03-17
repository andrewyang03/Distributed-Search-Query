package com.example.indexer.repository;

import com.example.indexer.model.SearchedPage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SearchPageRepository extends ElasticsearchRepository<SearchedPage, String> {
    List<SearchedPage> findByContentContaining(String keyword);
}