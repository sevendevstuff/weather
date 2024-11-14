package com.stefan.weather.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
    @NotNull
    String email;
    @NotNull
    String password;
}
