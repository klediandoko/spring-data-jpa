package com.doko.internship.jpaintro.repository;

import com.doko.internship.jpaintro.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query(
            "Select u from User u " +
                    "join Booking b on u.id = b.user.id " +
                    "join BookingFlight bf on bf.booking.bookingId = b.bookingId " +
                    "join Flight f on f.flightId = bf.flight.flightId " +
                    "where f.flightId = :flightId "
    )
    List<User> findAllUsersByFlightId(@Param("flightId") Long flightId);
}
