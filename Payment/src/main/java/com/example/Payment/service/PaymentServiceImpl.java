package com.example.Payment.service;

import com.example.Payment.entity.TransactionDetailsEntity;
import com.example.Payment.exception.InvalidPayment;
import com.example.Payment.exception.InvalidPaymentMode;
import com.example.Payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Payment service implementation
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public TransactionDetailsEntity makeTransaction(TransactionDetailsEntity payment) {
        // validate if paymentMode is not card or not upi then raise an error
        // return payment based on id from database if validation succeed and stores into the database
        if(payment.getPaymentMode() != null){
            String paymentMode = payment.getPaymentMode().toLowerCase().strip();
            if(!(paymentMode.equalsIgnoreCase("card") || paymentMode.equalsIgnoreCase("upi"))){
                throw new InvalidPaymentMode( "Invalid mode of payment", 400 );
            }
        } else {
            throw new InvalidPaymentMode( "Invalid mode of payment", 400 );
        }
        return paymentRepository.save(payment);
    }

    @Override
    public TransactionDetailsEntity getTransactionBasedOnId(int id) {
        // find payment/transaction from id into database raise error if id is not found
        if (paymentRepository.findById(id).isPresent()){
            return paymentRepository.findById(id).get();
        }
        throw new InvalidPayment( "Invalid Payment Id", 400 );
    }
}
