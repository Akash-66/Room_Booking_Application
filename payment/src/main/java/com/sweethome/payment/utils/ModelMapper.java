package com.sweethome.payment.utils;

import com.sweethome.payment.dto.TransactionDTO;
import com.sweethome.payment.entities.TransactionDetailsEntity;

public class ModelMapper {

    public static TransactionDetailsEntity transactionDTO2TransactionEntity(TransactionDTO transactionDTO){

        TransactionDetailsEntity transactionDetailsEntity = new TransactionDetailsEntity();
        transactionDetailsEntity.setTransactionId(transactionDTO.getTransactionId());
        transactionDetailsEntity.setBookingId(transactionDTO.getBookingId());
        transactionDetailsEntity.setCardNumber(transactionDTO.getCardNumber());
        transactionDetailsEntity.setPaymentMode(transactionDTO.getPaymentMode());
        transactionDetailsEntity.setUpiId(transactionDTO.getUpiId());

        return transactionDetailsEntity;
    }


    public static TransactionDTO transactionEntity2TransactionDTO(TransactionDetailsEntity transactionDetailsEntity){
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(transactionDetailsEntity.getTransactionId());
        transactionDTO.setBookingId(transactionDetailsEntity.getBookingId());
        transactionDTO.setCardNumber(transactionDetailsEntity.getCardNumber());
        transactionDTO.setPaymentMode(transactionDetailsEntity.getPaymentMode());
        transactionDTO.setUpiId(transactionDetailsEntity.getUpiId());

        return transactionDTO;
    }
}
