package com.future.phase2.ojekonline.service;

import com.future.phase2.ojekonline.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    List<Payment> getAllPayments();
}
