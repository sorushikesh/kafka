package com.kafka.dto;

public class MessageResponse {

    private String message;
    private String topic;
    private boolean success;

    // Constructor
    public MessageResponse(String message, String topic, boolean success) {
        this.message = message;
        this.topic = topic;
        this.success = success;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
