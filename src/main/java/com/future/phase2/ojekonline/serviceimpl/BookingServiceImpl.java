package com.future.phase2.ojekonline.serviceimpl;

import com.future.phase2.ojekonline.entity.Booking;
import com.future.phase2.ojekonline.repository.BookingRepository;
import com.future.phase2.ojekonline.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
}
