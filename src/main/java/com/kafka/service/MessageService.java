package com.kafka.service;

import com.kafka.dto.MessageResponse;

public interface MessageService {
    String generateRandomMessage();

    boolean sendMessage(String message, String topic);

    MessageResponse sendRandomMessage(String topic);
}
