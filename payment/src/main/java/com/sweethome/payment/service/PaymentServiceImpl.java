package com.sweethome.payment.service;

import com.sweethome.payment.dao.TransactionDetailsDAO;
import com.sweethome.payment.entities.TransactionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private TransactionDetailsDAO transactionDetailsDAO;


    @Override
    public TransactionDetailsEntity getTransactionDetailById(int transactionId) {

        return transactionDetailsDAO.findById(transactionId).get();
    }


    public int createTransaction(TransactionDetailsEntity transactionDetailsEntity) {

        return transactionDetailsDAO.save(transactionDetailsEntity).getTransactionId();

    }
}
