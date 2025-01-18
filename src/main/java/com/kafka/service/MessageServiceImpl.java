package com.kafka.service;

import com.kafka.dto.MessageResponse;
import com.kafka.util.RandomMessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String generateRandomMessage() {
        return RandomMessageUtil.getRandomMessage();
    }

    @Override
    public boolean sendMessage(String message, String topic) {
        try {
            kafkaTemplate.send(topic, message).get();
            return true;
        } catch (Exception e) {
            logger.error("Error sending message to Kafka topic: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public MessageResponse sendRandomMessage(String topic) {
        try {

            String message = RandomMessageUtil.getRandomMessage();
            kafkaTemplate.send(topic, message).get();
            return new MessageResponse(message, topic, true);
        } catch (Exception e) {
            logger.error("Error sending random message to Kafka topic: {}", e.getMessage());
            return new MessageResponse(null, topic, false);
        }
    }
}
