package com.doko.internship.jpaintro.repository;

import com.doko.internship.jpaintro.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
