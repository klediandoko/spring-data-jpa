package com.doko.internship.jpaintro.controller;

import com.doko.internship.jpaintro.model.resources.BookingResource;
import com.doko.internship.jpaintro.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingResource>> getBookingsByUserId(@PathVariable("userId") Long id) {
        List<BookingResource> bookings = bookingService.findBookingsByUserId(id);

        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping(path = "/{bookingId}", produces = "application/json")
    public ResponseEntity<Void> deleteBooking(@PathVariable("bookingId") final Long bookingId) {
        bookingService.deleteBookingById(bookingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingResource>> getAllOrderedByDate() {
        return ResponseEntity.ok(bookingService.getAllBookingsOrderedByDate());
    }

    @GetMapping(path = "/search")
    public ResponseEntity<Optional<BookingResource>> getByBookingIdAndUserId(
            @RequestParam("bookingId") final Long bookingId,
            @RequestParam("userId") final Long userId) {

        Optional<BookingResource> bookingResource = bookingService.findBookingByIdAndUserId(bookingId, userId);
        return ResponseEntity.ok(bookingResource);
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<BookingResource>> getBookingsByFlightId(@PathVariable("flightId") Long flightId) {
        return ResponseEntity.ok(bookingService.findBookingsByFlightId(flightId));
    }

    @PutMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> save(
            @RequestBody BookingResource bookingResource,
            @RequestParam("userId") Long userId,
            @RequestParam("flightId") Long flightId) {
        bookingService.saveBooking(bookingResource, userId, flightId);
        return ResponseEntity.noContent().build();
    }
}

