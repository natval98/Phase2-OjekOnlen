package com.future.phase2.ojekonline.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "BOOKING")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @Column
    private Double amount;

    @Column
    private String addressFrom;

    @Column
    private String addressTo;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    public enum bookingType {
        REQUEST,
        ONGOING,
        DONE,
        BOOKED,
        CANCELLED
    }

    @Column
    private bookingType bookingType;
}
