package com.example.Booking.service;

import com.example.Booking.dto.BookingTransactionDTO;
import com.example.Booking.entity.BookingInfoEntity;

import java.io.IOException;

// Booking service Interface
public interface BookingService {

    public BookingInfoEntity makeBooking(BookingInfoEntity booking);

    public BookingInfoEntity getBookingBasedOnId(int id);

    public BookingInfoEntity updateBookingByCreatingTransaction(int id, BookingTransactionDTO bookingTransactionDTO);

    public void sendNotification(String topic, String key, String value) throws IOException;

}
