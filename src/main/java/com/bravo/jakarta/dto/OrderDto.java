package com.bravo.jakarta.dto;

import com.bravo.jakarta.entities.Booking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class OrderDto {
    private Booking booking;
    private Double priceBooking;

    public OrderDto() {
    }

    public OrderDto(Booking booking) {
        this.booking = booking;
        if(booking.getEnds().isBefore(LocalDateTime.now())) {
            this.priceBooking = (double) (ChronoUnit.DAYS.between(booking.getStarts(), booking.getEnds()) * booking.getCar().getDailyCost());
        } else if(booking.getStarts().isAfter(LocalDateTime.now())) {
            this.priceBooking = 0.0;
        } else {
            this.priceBooking = (double) (ChronoUnit.DAYS.between(booking.getStarts(), LocalDateTime.now()) * booking.getCar().getDailyCost());
        }
    }

    public OrderDto(Booking booking, Double priceBooking) {
        this.booking = booking;
        this.priceBooking = priceBooking;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Double getPriceBooking() {
        return priceBooking;
    }

    public void setPriceBooking(Double priceBooking) {
        this.priceBooking = priceBooking;
    }
}
