package com.doko.internship.jpaintro.repository;

import com.doko.internship.jpaintro.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {


    List<Booking> findByUserId(Long id);


    List<Booking> findAllByOrderByBookingDateDesc();

    Optional<Booking> findByBookingIdAndUserId(Long bookingId, Long userId);

    @Query(value = "SELECT b FROM Booking b " +
            "join BookingFlight bf on bf.booking.bookingId = b.bookingId " +
            "join Flight f on f.flightId= bf.flight.flightId " +
            "where f.flightId = :flightId ")
    List<Booking> findAllByFlightId(@RequestParam("flightId") Long flightId);

    //void saveBooking
}
