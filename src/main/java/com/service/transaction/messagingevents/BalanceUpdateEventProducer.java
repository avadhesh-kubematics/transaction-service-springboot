package com.service.transaction.messagingevents;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Component
public class BalanceUpdateEventProducer {

    private KafkaTemplate<String, Double> kafkaTemplate;
    private String topicName;

    public BalanceUpdateEventProducer(KafkaTemplate kafkaTemplate, @Value("${kafka.topicName}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void publishUpdateBalance(double actualBalance) {
        log.info("BalanceUpdateEventProducer:produceBalanceUpdate : Init..");
        ListenableFuture listenableFuture = kafkaTemplate.send(topicName, actualBalance);
        log.debug("BalanceUpdateEventProducer:produceBalanceUpdate listenableFuture : {}", listenableFuture);
        log.info("BalanceUpdateEventProducer:produceBalanceUpdate : End..");
    }
}