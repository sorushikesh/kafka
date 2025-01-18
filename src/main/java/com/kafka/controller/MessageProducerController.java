package com.kafka.controller;

import com.kafka.dto.MessageResponse;
import com.kafka.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducerController {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducerController.class);

    private final MessageService messageService;

    @Value("${spring.kafka.consumer.topic-name}")
    private String topic;

    public MessageProducerController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/produce")
    public ResponseEntity<MessageResponse> produceMessage() {
        MessageResponse response = messageService.sendRandomMessage(topic);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
