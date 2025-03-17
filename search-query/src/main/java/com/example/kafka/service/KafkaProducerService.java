package com.example.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "urls-to-crawl";

    @Autowired
    private KafkaTemplate <String, String> kafkaTemplate;

    // Sends urls to the Kafka topics
    public void sendUrl(String url) {
        kafkaTemplate.send(TOPIC, url);
    }
}