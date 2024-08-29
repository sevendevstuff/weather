package com.stefan.weather.db;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "example")
@Data
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String exampleString;

    private Long exampleLong;
}
