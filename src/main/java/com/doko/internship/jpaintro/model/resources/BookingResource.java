package com.doko.internship.jpaintro.model.resources;

import com.doko.internship.jpaintro.model.entity.Booking;
import com.doko.internship.jpaintro.model.enums.BookingStatus;

import java.util.Date;

public class BookingResource {

    private Long bookingId;
    private Date bookingDate;
    private BookingStatus bookingStatus;

    public BookingResource() {
    }

    public BookingResource(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.bookingDate = booking.getBookingDate();
        this.bookingStatus = booking.getBookingStatus();

    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
