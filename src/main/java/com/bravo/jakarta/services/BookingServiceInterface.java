package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Booking;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Book;
import java.util.List;

public interface BookingServiceInterface {
    List<Booking> getAllBookings();

    void deleteBooking(Long id);

    void cancelBooking(Long id);
}
