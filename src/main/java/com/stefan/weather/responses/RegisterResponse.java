package com.stefan.weather.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterResponse {
    @JsonProperty("message")
    String message;
}
