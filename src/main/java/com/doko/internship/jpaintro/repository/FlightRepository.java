package com.doko.internship.jpaintro.repository;

import com.doko.internship.jpaintro.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
