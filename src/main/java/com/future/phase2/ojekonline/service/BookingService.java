package com.future.phase2.ojekonline.service;

import com.future.phase2.ojekonline.entity.Booking;
import com.future.phase2.ojekonline.entity.Member;

import java.text.ParseException;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking createBooking(Booking booking, Long memberId, Long driverId, Integer paymentId) throws ParseException;
    Booking cancelBooking(String id);

    List<Booking> listMemberBookingHistory(Long memberId);
}
