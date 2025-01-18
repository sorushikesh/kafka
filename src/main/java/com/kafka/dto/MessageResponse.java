package com.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponse {

    private String message;
    private String topic;
    private boolean success;
}
