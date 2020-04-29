package com.service.transaction.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TransactionConfiguration {

    private String bootstrapAddress;
    private String topicName;

    public TransactionConfiguration(@Value(value = "${kafka.bootstrapAddress}") String bootstrapAddress,
                                    @Value(value = "${kafka.topicName}") String topicName) {
        this.bootstrapAddress = bootstrapAddress;
        this.topicName = topicName;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
}
