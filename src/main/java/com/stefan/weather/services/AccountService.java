package com.stefan.weather.services;

import com.stefan.weather.requests.RegisterRequest;

public interface AccountService {
    String register(RegisterRequest req);
}
