package com.example.Booking.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;

// booking table entity class to map to and from database
@Entity(name="booking")
@JsonPropertyOrder({"id"})
public class BookingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int bookingId ;

    @Column(nullable = true)
    private Date fromDate;

    @Column(nullable = true)
    private Date toDate;

    @Column(nullable = true)
    private String aadharNumber ;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int numOfRooms ;

    private String roomNumbers ;

    @Column(nullable = false)
    private int roomPrice ;

    private int transactionId=0;

    @Column(nullable = true)
    private Date bookedOn;

    public BookingInfoEntity() {
    }

    public BookingInfoEntity(int bookingId, int numOfRooms, int roomPrice) {
        this.bookingId = bookingId;
        this.numOfRooms = numOfRooms;
        this.roomPrice = roomPrice;
    }

    @JsonProperty("id")
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(Date bookedOn) {
        this.bookedOn = bookedOn;
    }

    public BookingInfoEntity(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "BookingInfoEntity{" +
                "bookingId=" + bookingId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", numOfRooms=" + numOfRooms +
                ", roomNumbers='" + roomNumbers + '\'' +
                ", roomPrice=" + roomPrice +
                ", transactionId=" + transactionId +
                ", bookedOn='" + bookedOn + '\'' +
                '}';
    }
}
