package com.future.phase2.ojekonline.repository;

import com.future.phase2.ojekonline.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment, Integer> {
}
