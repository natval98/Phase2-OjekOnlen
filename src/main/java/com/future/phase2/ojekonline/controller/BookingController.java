package com.future.phase2.ojekonline.controller;

import com.future.phase2.ojekonline.entity.Booking;
import com.future.phase2.ojekonline.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }
}
