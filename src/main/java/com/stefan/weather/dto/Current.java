package com.stefan.weather.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Current {
    LocalDateTime time;
    Double temperature_2m;
    Double wind_speed_10m;
}
