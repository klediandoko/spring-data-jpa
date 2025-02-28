package com.doko.internship.jpaintro.repository;

import com.doko.internship.jpaintro.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f " +
            "WHERE f.origin = :origin " +
            "AND f.departureDate >= :startOfDay " +
            "AND f.departureDate < :endOfDay")
    List<Flight> findByDepartureDateAndOrigin(
            @Param("origin") String origin,
            @Param("startOfDay") LocalDateTime startOfDay,
            @Param("endOfDay") LocalDateTime endOfDay
    );
}
