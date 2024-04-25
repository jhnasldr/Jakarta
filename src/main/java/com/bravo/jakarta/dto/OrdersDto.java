package com.bravo.jakarta.dto;

import com.bravo.jakarta.entities.Booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdersDto {
    private List<OrderDto> bookings;
    private double totalPriceClosedBookings;

    public OrdersDto() {
    }

    public OrdersDto(List<OrderDto> bookings, double totalPriceClosedBookings) {
        this.bookings = bookings;
        this.totalPriceClosedBookings = totalPriceClosedBookings;
    }

    public OrdersDto(List<Booking> bookings) {
        this.bookings = new ArrayList<>();
        for (Booking booking: bookings) {
            OrderDto orderDto = new OrderDto(booking);
            this.bookings.add(orderDto);
            if(booking.getEnds().isBefore(LocalDateTime.now())){
                this.totalPriceClosedBookings += orderDto.getPriceBooking();
            }
        }
    }

    public List<OrderDto> getBookings() {
        return bookings;
    }

    public void setBookings(List<OrderDto> bookings) {
        this.bookings = bookings;
    }

    public double getTotalPriceClosedBookings() {
        return totalPriceClosedBookings;
    }

    public void setTotalPriceClosedBookings(double totalPriceClosedBookings) {
        this.totalPriceClosedBookings = totalPriceClosedBookings;
    }
}
