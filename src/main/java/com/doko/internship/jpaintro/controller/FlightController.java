package com.doko.internship.jpaintro.controller;

import com.doko.internship.jpaintro.model.resources.FlightResource;
import com.doko.internship.jpaintro.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<FlightResource>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightResource> getFlightById(@PathVariable("flightId") Long id) {
        Optional<FlightResource> flightResource = flightService.getFlightById(id);
        return flightResource.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{departureDate}/{origin}")
    public ResponseEntity<List<FlightResource>> getFlightsByDateAndOrigin(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
            @PathVariable String origin
    ) {
        List<FlightResource> flights = flightService.getFlightsByDateAndOrigin(departureDate, origin);
        return ResponseEntity.ok(flights);
    }

    @PutMapping(path = "{flightId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> updateFlight(@PathVariable("flightId") final Long flightId,
                                           @RequestBody final FlightResource flight) {
        flightService.save(flightId, flight);
        return ResponseEntity.noContent().build();
    }


}

