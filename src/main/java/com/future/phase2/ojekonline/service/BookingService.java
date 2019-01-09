package com.future.phase2.ojekonline.service;

import com.future.phase2.ojekonline.entity.Booking;

import java.text.ParseException;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking createBooking(Booking booking, Long memberId, Long driverId, Integer paymentId) throws ParseException;
}
