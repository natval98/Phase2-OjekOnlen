package com.future.phase2.ojekonline.repository;

import com.future.phase2.ojekonline.entity.Booking;
import com.future.phase2.ojekonline.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    List<Booking> findBookingsByMember(Member member);
}
