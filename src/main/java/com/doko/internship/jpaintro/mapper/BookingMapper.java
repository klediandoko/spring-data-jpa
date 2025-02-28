package com.doko.internship.jpaintro.mapper;

import com.doko.internship.jpaintro.model.entity.Booking;
import com.doko.internship.jpaintro.model.resources.BookingResource;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingResource toResource(final Booking booking) {
       return new BookingResource(booking);
    }


    public void updateBooking(Booking bookingToUpdate, BookingResource bookingResource) {
        bookingToUpdate.setBookingDate(bookingResource.getBookingDate());
        bookingToUpdate.setBookingStatus(bookingResource.getBookingStatus());
    }
}
