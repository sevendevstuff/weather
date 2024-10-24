package com.stefan.weather.services;

import com.stefan.weather.db.Account;
import com.stefan.weather.db.City;
import com.stefan.weather.repositories.AccountRepository;
import com.stefan.weather.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequest req) {
        Account account = repository.save(mapRegisterRequestToAccountEntity(req));
        return "Successful";
    }

    private Account mapRegisterRequestToAccountEntity(RegisterRequest req) {
        String hashedPassword = passwordEncoder.encode(req.getPassword());
        return new Account(req.getFirstName(), req.getLastName(), req.getEmail(), hashedPassword, List.of());
    }
}
