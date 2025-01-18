package com.kafka.service;

import com.kafka.dto.MessageResponse;

public interface MessageService {

    MessageResponse sendRandomMessage(String topic);
}
