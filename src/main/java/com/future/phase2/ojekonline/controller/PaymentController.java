package com.future.phase2.ojekonline.controller;

import com.future.phase2.ojekonline.entity.Payment;
import com.future.phase2.ojekonline.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "payment")
public class PaymentController {
//    https://www.baeldung.com/spring-boot-logging
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    // Insert Payment
    @GetMapping("/")
    public String index(){
        logger.trace("A trace message"); // paling tinggi dan menjalankan semua yang ada di bawahnya
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Check out the LOgs!";
    }

    @Autowired
    PaymentService paymentService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Payment>> getAllPayments(){
        return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
        return new ResponseEntity<>(paymentService.createPayment(payment), HttpStatus.CREATED);
    }

}
