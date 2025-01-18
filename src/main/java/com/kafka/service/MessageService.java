package com.kafka.service;

public interface MessageService {
    String generateRandomMessage();

    void sendMessage(String message);
}
