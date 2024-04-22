package com.bravo.jakarta.repositories;

import com.bravo.jakarta.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingByCar_IdAndEndsAfterAndStartsBefore(int car_id, LocalDateTime starts, LocalDateTime ends);
}
