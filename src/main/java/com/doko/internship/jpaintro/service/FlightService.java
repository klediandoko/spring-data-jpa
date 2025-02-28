package com.doko.internship.jpaintro.service;

import com.doko.internship.jpaintro.mapper.FlightMapper;
import com.doko.internship.jpaintro.model.entity.Flight;
import com.doko.internship.jpaintro.model.resources.FlightResource;
import com.doko.internship.jpaintro.model.resources.UserResource;
import com.doko.internship.jpaintro.repository.FlightRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public FlightService(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    public List<FlightResource> getAllFlights() {
        return flightRepository.findAll().stream()
                .map(flightMapper::toResource)
                .toList();
    }

    public Optional<FlightResource> getFlightById(Long id) {
        return flightRepository.findById(id).map(flightMapper::toResource);
    }

    public List<FlightResource> getFlightsByDateAndOrigin(LocalDate departureDate, String origin) {

        LocalDateTime startOfDay = departureDate.atStartOfDay();
        LocalDateTime endOfDay = departureDate.plusDays(1).atStartOfDay();

        List<Flight> flights = flightRepository.findByDepartureDateAndOrigin(origin, startOfDay, endOfDay);

        return flights.stream().map(flightMapper::toResource).toList();
    }

    @Transactional
    public void save(final Long flightId, final FlightResource flightResource) {
        Flight flightToUpdate = flightRepository.findById(flightId).orElseGet(Flight::new);
        flightMapper.updateFlight(flightToUpdate, flightResource);

        flightRepository.save(flightToUpdate);

    }

    public void deleteFlight(final Long flightId) {

    }
}
