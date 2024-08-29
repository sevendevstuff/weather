package com.stefan.weather.requests;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class ExampleRequest {
    @NotNull(message = "String should not be null")
    private String exampleString;
    private Long exampleLong;
}
