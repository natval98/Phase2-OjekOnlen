package com.future.phase2.ojekonline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DRIVER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Double balance;

    @Column
    private String motorNum;

    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    List<Booking> bookings;

    public Driver(Long id, String name, Double balance, String motorNum) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.motorNum = motorNum;
    }

    public Driver(String name, Double balance, String motorNum) {
        this.name = name;
        this.balance = balance;
        this.motorNum = motorNum;
    }
}
