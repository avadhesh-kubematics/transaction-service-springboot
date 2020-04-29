package com.service.transaction.messagingevents;

import com.service.transaction.model.TransactionVO;
import com.service.transaction.service.TransactionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventConsumer {

    private TransactionService transactionService;

    public TransactionEventConsumer(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @KafkaListener(topics = "transaction", groupId = "transaction-group")
    public void consumeTransaction(TransactionVO transactionVO) {
        this.transactionService.processTransaction(transactionVO);
    }
}