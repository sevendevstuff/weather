package com.stefan.weather.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CarRequest {
    @NotNull
    private String name;
    private Integer doorNumber;
    private String fabricationYear;
}
