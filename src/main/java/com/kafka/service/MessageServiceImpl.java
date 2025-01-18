package com.kafka.service;

import com.kafka.util.RandomMessageUtil;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "your-topic-name";

    public MessageService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String generateRandomMessage() {
        return RandomMessageUtil.getRandomMessage();
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
