package com.doko.internship.jpaintro.model.resources;

import com.doko.internship.jpaintro.model.entity.Flight;
import com.doko.internship.jpaintro.model.enums.FlightStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


public class FlightResource {

    private String origin;
    private String destination;
    private String airline;
    private String flightNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime departureDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime arrivalDate;
    private FlightStatus flightStatus;

    public FlightResource() {
    }

    public FlightResource(Flight flight) {
        this.origin = flight.getOrigin();
        this.destination = flight.getDestination();
        this.airline = flight.getAirline();
        this.flightNumber = flight.getFlightNumber();
        this.departureDate = flight.getDepartureDate();
        this.arrivalDate = flight.getArrivalDate();
        this.flightStatus = flight.getFlightStatus();
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
}
