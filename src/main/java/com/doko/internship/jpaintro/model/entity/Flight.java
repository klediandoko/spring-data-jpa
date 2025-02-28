package com.doko.internship.jpaintro.model.entity;

import com.doko.internship.jpaintro.model.enums.FlightStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long flightId;
    @Column(name = "origin", nullable = false)
    private String origin;
    @Column(name = "destination", nullable = false)
    private String destination;
    @Column(name = "airline", nullable = false)
    private String airline;
    @Column(name = "flight_number", nullable = false)
    private String flightNumber;
    @Column(name = "departure_date", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime departureDate;
    @Column(name = "arrival_date", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime arrivalDate;
    @Column(name = "flight_status", nullable = false)
    private FlightStatus flightStatus;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BookingFlight> bookingFlights;

    public Set<Booking> getBookings() {
        return bookingFlights.stream().map(BookingFlight::getBooking).collect(Collectors.toSet());
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {

        this.flightId = flightId;
    }

    public String getOrigin() {

        return origin;
    }

    public void setOrigin(String origin) {

        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {

        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {

        this.flightNumber = flightNumber;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public FlightStatus getFlightStatus() {

        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {

        this.flightStatus = flightStatus;
    }

    public Set<BookingFlight> getBookingFlights() {
        return bookingFlights;
    }

    public void setBookingFlights(Set<BookingFlight> bookingFlights) {
        this.bookingFlights = bookingFlights;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", flightStatus=" + flightStatus +
                '}';
    }
}
