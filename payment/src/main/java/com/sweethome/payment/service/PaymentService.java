package com.sweethome.payment.service;

import com.sweethome.payment.entities.TransactionDetailsEntity;

public interface PaymentService {

    public int createTransaction(TransactionDetailsEntity transactionDetailsEntity);

    public TransactionDetailsEntity getTransactionDetailById(int transactionId);
}
