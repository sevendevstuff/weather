package com.stefan.weather.db;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public Double lat;
    public Double lng;

    @Column(unique = true, nullable = false)
    public String name;

    @OneToOne(fetch = FetchType.EAGER)
    public WeatherCondition weatherCondition;
}
