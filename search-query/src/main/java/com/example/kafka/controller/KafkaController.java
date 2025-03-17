package com.example.kafka;

import com.example.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crawl/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducerService KafkaProducerService;

    @PostMapping
    public String sendToKafka(@RequestParam String url) {
        KafkaProducerService.sendUrl(url);
        return "URL added to queue" + url + "\n";
    }
}