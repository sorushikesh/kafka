package com.kafka.service;

import com.kafka.util.RandomMessageUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.consumer.topic-name}")
    private String TOPIC;

    public MessageServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String generateRandomMessage() {
        return RandomMessageUtil.getRandomMessage();
    }

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
