package com.kafka.controller;

import com.kafka.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducerController {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducerController.class);

    private final MessageService messageService;

    public MessageProducerController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/produce")
    public ResponseEntity<String> produceMessage() {
        String message = messageService.generateRandomMessage();
        logger.info("Generated Message: {}", message);
        messageService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body("Message sent to topic: " + message);
    }
}
