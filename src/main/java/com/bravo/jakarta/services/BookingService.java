package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Booking;
import com.bravo.jakarta.exceptions.ResourceNotFoundException;
import com.bravo.jakarta.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements BookingServiceInterface{
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBooking(Long id) {
        Booking bookingToDelete = bookingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking", "id", id));
        bookingRepository.delete(bookingToDelete);
    }

    public void cancelBooking(Long id) {
        Booking bookingToCancel = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
        bookingRepository.delete(bookingToCancel);
    }


}
