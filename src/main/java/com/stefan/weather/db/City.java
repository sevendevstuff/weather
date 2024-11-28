package com.stefan.weather.db;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

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

    @Column(columnDefinition = "jsonb")
    public WeatherCondition weatherCondition;

    // De rezolvat eroarea cu serializarea de la JSON si dupa testare metoda de test getWeatherForCity
}
