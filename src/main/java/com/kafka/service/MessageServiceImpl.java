package com.kafka.service;

import com.kafka.config.KafkaTopicsConfig;
import com.kafka.dto.MessageResponse;
import com.kafka.util.MoodBasedMessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTopicsConfig kafkaTopicsConfig;

    public MessageServiceImpl(KafkaTemplate<String, String> kafkaTemplate, KafkaTopicsConfig kafkaTopicsConfig) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopicsConfig = kafkaTopicsConfig;
    }

    @Override
    public MessageResponse sendRandomMessage(String mood) {
        Map<String, String> topicMappings = kafkaTopicsConfig.getTopics();
        String topic = topicMappings.getOrDefault(mood.toLowerCase(), null);
        if (topic == null) {
            throw new IllegalArgumentException("Invalid mood: " + mood);
        }
        try {

            String message = MoodBasedMessageUtil.getRandomMessageByMood(mood);
            kafkaTemplate.send(topic, message).get();
            return new MessageResponse(message, topic, true);
        } catch (Exception e) {
            logger.error("Error sending message to Kafka topic: {}", e.getMessage());
            return new MessageResponse(null, null, false);
        }
    }
}
