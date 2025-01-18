package com.kafka.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaTopicsConfig {
    private Map<String, String> topics;
}

