package com.doko.internship.jpaintro.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_flight")
public class BookingFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)
    private Flight flight;

    public Flight getFlight() {

        return flight;
    }

    public Booking getBooking() {
        return booking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "BookingFlight{" +
                "id=" + id +
                ", booking=" + booking +
                ", flight=" + flight +
                '}';
    }
}
