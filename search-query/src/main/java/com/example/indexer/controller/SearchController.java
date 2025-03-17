package com.example.indexer.controller;

import com.example.indexer.model.SearchedPage;
import com.example.indexer.repository.SearchPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchPageRepository searchPageRepository;

    @GetMapping
    public List<SearchedPage> search(@RequestParam String query) {
        return searchPageRepository.findByContentContaining(query);
    }
}