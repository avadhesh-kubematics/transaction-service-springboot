package com.service.transaction.service;

import com.service.transaction.messagingevents.BalanceUpdateEventProducer;
import com.service.transaction.model.TransactionDAO;
import com.service.transaction.model.TransactionVO;
import com.service.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.service.transaction.mapper.TransactionVOToTransactionDAOMapper.MAPPER;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private BalanceUpdateEventProducer balanceUpdateEventProducer;

    public TransactionService(TransactionRepository transactionRepository,
                              BalanceUpdateEventProducer balanceUpdateEventProducer) {
        this.transactionRepository = transactionRepository;
        this.balanceUpdateEventProducer = balanceUpdateEventProducer;
    }

    public double processTransaction(TransactionVO transactionVO) {
        double currentBalance = getCurrentBalance(transactionVO.getAccountNumber());
        if ("credit".equalsIgnoreCase(transactionVO.getTransactionType())) {
            currentBalance += transactionVO.getAmount();
        } else {
            currentBalance -= transactionVO.getAmount();
        }
        this.balanceUpdateEventProducer.publishUpdateBalance(currentBalance);
        this.transactionRepository.save(MAPPER.map(transactionVO));

        return currentBalance;
    }

    private double getCurrentBalance(int accountNumber) {
        List<TransactionDAO> transactionsByAccountNumber = this.transactionRepository.
                findTransactionsByAccountNumber(accountNumber);
        double currentBalance = 0;
        for (TransactionDAO transaction : transactionsByAccountNumber) {
            if ("credit".equalsIgnoreCase(transaction.getTransactionType())) {
                currentBalance += transaction.getAmount();
            } else {
                currentBalance -= transaction.getAmount();
            }
        }
        return currentBalance;
    }
}
