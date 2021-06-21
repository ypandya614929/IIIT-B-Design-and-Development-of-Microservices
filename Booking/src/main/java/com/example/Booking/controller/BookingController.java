package com.example.Booking.controller;

import com.example.Booking.dto.BookingDTO;
import com.example.Booking.dto.BookingTransactionDTO;
import com.example.Booking.entity.BookingInfoEntity;
import com.example.Booking.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping
public class BookingController {

    // bookingService instance is used to invoke booking related methods
    @Autowired
    private BookingService bookingService ;

    @Autowired
    ModelMapper modelMapper;

    // POST API to create booking and store into Database
    // It will return booking detail data as a response
    @PostMapping(value="/booking", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBooking(@RequestBody BookingDTO bookingDTO){

        BookingInfoEntity booking = modelMapper.map(bookingDTO, BookingInfoEntity.class);
        BookingInfoEntity savedBooking = bookingService.makeBooking(booking);
        BookingDTO savedbookingDTO = modelMapper.map(savedBooking, BookingDTO.class);
        return new ResponseEntity(savedbookingDTO, HttpStatus.CREATED);
    }

    // POST API to confirm booking and store into Database as a booking transaction
    // It will return booking transaction detail data as a response
    @PostMapping(value="/booking/{bookingId}/transaction", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity confirmBooking(
            @PathVariable(name = "bookingId")  int bookingId,
            @RequestBody BookingTransactionDTO bookingTransactionDTO) throws IOException {

        BookingInfoEntity savedBooking = bookingService.updateBookingByCreatingTransaction(bookingId, bookingTransactionDTO);
        String message = "Booking confirmed for user with aadhaar number: " + savedBooking.getAadharNumber() +    "    |    "  + "Here are the booking details:    " + savedBooking.toString();

        // kafka notification send after successful transaction
        bookingService.sendNotification("message", "notification", message);

        return new ResponseEntity(savedBooking, HttpStatus.CREATED);
    }

}
