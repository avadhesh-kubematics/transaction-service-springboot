package com.service.transaction.service;

import com.service.transaction.connector.BalanceConnector;
import com.service.transaction.model.TransactionVO;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

//    private BalanceConnector balanceConnector;
//    private EventMessagingConnector eventMessagingConnector;
//
//    public CashierService(BalanceConnector balanceConnector, EventMessagingConnector eventMessagingConnector) {
//        this.balanceConnector = balanceConnector;
//        this.eventMessagingConnector = eventMessagingConnector;
//    }
//
//    public void create(TransactionVO transaction) {
//        this.balanceConnector.invokeAccountService(transaction.getAccountNumber());
//        this.eventMessagingConnector.produceEventMessage(transaction);
//    }
}
