package com.future.phase2.ojekonline.serviceimpl;

import com.future.phase2.ojekonline.entity.Payment;
import com.future.phase2.ojekonline.repository.PaymentRepository;
import com.future.phase2.ojekonline.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
//    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

//    public PaymentServiceImpl() {
//        logger.warn("nani");
//        apa();
//    }
//
//    public void apa(){
//        logger.warn("Terserah bebas");
//    }

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment){
        Payment existPayment = paymentRepository.findOne(payment.getId());
        if (existPayment == null) return paymentRepository.save(payment);
        else throw new RuntimeException("Payment Already Exists!");
    }

    @Override
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

}
