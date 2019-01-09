package com.future.phase2.ojekonline.controller;

import com.future.phase2.ojekonline.entity.Booking;
import com.future.phase2.ojekonline.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping(value = "booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    // List booking
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    // Request booking NOW / LATER
    @PostMapping("/create")
    @ResponseBody
    public Booking createBooking(
            @RequestBody Booking booking,
            @RequestParam(value = "memberId") Long memberId,
            @RequestParam(value = "driverId") Long driverId,
            @RequestParam(value = "paymentId") Integer paymentId) throws ParseException {
        return bookingService.createBooking(booking, memberId, driverId, paymentId);
    }

    // Cancel booking
    @PutMapping("/{id}/cancel")
    @ResponseBody
    public Booking cancelBooking(@PathVariable String id){
        return bookingService.cancelBooking(id);
    }

}
