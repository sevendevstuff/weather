package com.stefan.weather.services;

import com.stefan.weather.requests.LoginRequest;
import com.stefan.weather.requests.RegisterRequest;

public interface AccountService {
    String register(RegisterRequest req);

    void login(LoginRequest req);
    void addCityForAccount(Integer city_id, Integer account_id);
    void deleteCityForAccount(Integer city_id, Integer account_id);
}
