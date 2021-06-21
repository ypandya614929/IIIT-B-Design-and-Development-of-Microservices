package com.example.Payment.service;

import com.example.Payment.entity.TransactionDetailsEntity;

// Payment service Interface
public interface PaymentService {

    public TransactionDetailsEntity makeTransaction(TransactionDetailsEntity payment);

    public TransactionDetailsEntity getTransactionBasedOnId(int id);

}
