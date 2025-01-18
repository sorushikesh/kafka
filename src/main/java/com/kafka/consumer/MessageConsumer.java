package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class MessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = {"kafka-demo-topic-happy"}, groupId = "${spring.kafka.consumer.group-id}")
    public void consumeHappy(String message,
                             @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                             @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
        logger.info("Consumed message from topic '{}': '{}', Timestamp: {}", topic, message, Instant.ofEpochMilli(timestamp));
    }

    @KafkaListener(topics = {"kafka-demo-topic-sad"}, groupId = "${spring.kafka.consumer.group-id}")
    public void consumeSad(String message,
                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                           @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
        logger.info("Consumed message from topic '{}': '{}', Timestamp: {}", topic, message, Instant.ofEpochMilli(timestamp));
    }

    @KafkaListener(topics = {"kafka-demo-topic-neutral"}, groupId = "${spring.kafka.consumer.group-id}")
    public void consumeNeutral(String message,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
        logger.info("Consumed message from topic '{}': '{}', Timestamp: {}", topic, message, Instant.ofEpochMilli(timestamp));
    }
}
