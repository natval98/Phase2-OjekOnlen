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
}
