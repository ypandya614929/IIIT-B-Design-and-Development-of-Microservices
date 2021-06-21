package com.example.Booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

// DTO class which is used to map booking transaction
public class BookingTransactionDTO {

    @NotNull
    private String paymentMode;

    @NotNull
    private int bookingId;

    private int transactionId;

    private String upiId ;

    private String cardNumber ;

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    @JsonProperty("id")
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "BookingTransactionDTO{" +
                "paymentMode='" + paymentMode + '\'' +
                ", bookingId=" + bookingId +
                ", transactionId=" + transactionId +
                ", upiId='" + upiId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
