package com.stefan.weather.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity(name = "car")
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer doorNumber;

    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate fabricationYear;
}
