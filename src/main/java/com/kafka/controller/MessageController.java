package com.kafka.controller;

import com.kafka.dto.MessageResponse;
import com.kafka.model.MoodRequest;
import com.kafka.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/produce")
    public ResponseEntity<MessageResponse> produceMessage(@RequestBody MoodRequest moodRequest) {
        String mood = moodRequest.getMood();
        MessageResponse response = messageService.sendRandomMessage(mood);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
