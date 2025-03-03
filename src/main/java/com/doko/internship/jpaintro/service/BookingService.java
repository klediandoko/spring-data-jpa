package com.doko.internship.jpaintro.service;

import com.doko.internship.jpaintro.mapper.BookingMapper;
import com.doko.internship.jpaintro.model.entity.Booking;
import com.doko.internship.jpaintro.model.entity.BookingFlight;
import com.doko.internship.jpaintro.model.entity.Flight;
import com.doko.internship.jpaintro.model.resources.BookingResource;
import com.doko.internship.jpaintro.repository.BookingRepository;
import com.doko.internship.jpaintro.repository.FlightRepository;
import com.doko.internship.jpaintro.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;

    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper, UserRepository userRepository, FlightRepository flightRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
    }


    public List<BookingResource> findBookingsByUserId(Long id) {
        return bookingRepository.findByUserId(id).stream().map(bookingMapper::toResource).toList();
    }


    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<BookingResource> getAllBookingsOrderedByDate() {
        return bookingRepository.findAllByOrderByBookingDateDesc().stream().map(bookingMapper::toResource).toList();
    }

    public Optional<BookingResource> findBookingByIdAndUserId(Long bookingId, Long userId) {
        return bookingRepository.findByBookingIdAndUserId(bookingId, userId).stream()
                .map(bookingMapper::toResource).findFirst();
    }

    public List<BookingResource> findBookingsByFlightId(Long flightId) {
        List<BookingResource> bookings = bookingRepository.findAllByFlightId(flightId).stream()
                .map(bookingMapper::toResource).toList();

        if (bookings.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No bookings found for flight ID: " + flightId);
        }
        return bookings;
    }

    @Transactional
    public void saveBooking(BookingResource bookingResource, Long userId, Long flightId) {
        Booking booking = bookingRepository.findById(bookingResource.getBookingId()).orElse(new Booking());

        if (booking.getBookingId() == null) {
            booking.setUser(userRepository.getReferenceById(userId));
        }
        bookingMapper.updateBooking(booking, bookingResource);

        Flight flight = flightRepository.getReferenceById(flightId);
        BookingFlight bookingFlight = new BookingFlight(booking, flight);
        booking.getBookingFlights().add(bookingFlight);

        bookingRepository.save(booking);
    }

}
