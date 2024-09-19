package com.stefan.weather.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity(name = "car")
@NoArgsConstructor
public class Car {
    public Car(Integer doorNumber, String name, LocalDate fabricationYear) {
        this.doorNumber = doorNumber;
        this.name = name;
        this.fabricationYear = fabricationYear;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer doorNumber;

    @Column(nullable = false, unique = true)
    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate fabricationYear;

    public void merge(Car c) {
        this.doorNumber = c.getDoorNumber();
        this.name = c.getName();
        this.fabricationYear = c.getFabricationYear();
    }
}
