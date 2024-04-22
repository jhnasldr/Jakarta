package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Booking;
import com.bravo.jakarta.exceptions.ResourceNotFoundException;
import com.bravo.jakarta.repositories.BookingRepository;
import com.bravo.jakarta.repositories.CarRepository;
import com.bravo.jakarta.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements BookingServiceInterface{
    private BookingRepository bookingRepository;
    private CarRepository carRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, CarRepository carRepository, CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking addBooking(Booking booking) {
        Booking addedBooking = null;
        List<Booking> overlappingBookings = bookingRepository.findBookingByCar_IdAndEndsAfterAndStartsBefore(booking.getCar().getId(), booking.getStarts(), booking.getEnds());
        if(overlappingBookings.isEmpty()){
            if(booking.getEnds().isAfter(booking.getStarts())) {
                carRepository.findById(booking.getCar().getId()).orElseThrow(() -> new ResourceNotFoundException("addBooking", "car", booking.getCar().getId()));
                customerRepository.findById(booking.getCustomer().getId()).orElseThrow(() -> new ResourceNotFoundException("addBooking", "customer_id", booking.getCustomer().getId()));
                booking.setId(null);
                addedBooking = bookingRepository.save(booking);
            }
        }
        return addedBooking;
    }

    @Override
    public void deleteBooking(Long id) {
        Booking bookingToDelete = bookingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking", "id", id));
        bookingRepository.delete(bookingToDelete);
    }
}
