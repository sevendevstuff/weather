package com.stefan.weather.services;

import com.stefan.weather.db.Account;
import com.stefan.weather.db.City;
import com.stefan.weather.repositories.AccountRepository;
import com.stefan.weather.repositories.CityRepository;
import com.stefan.weather.requests.LoginRequest;
import com.stefan.weather.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CityRepository cityRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequest req) {
        Account account = accountRepository.save(mapRegisterRequestToAccountEntity(req));
        return "Successful";
    }

    @Override
    public void login(LoginRequest req) {
        Account acc = accountRepository.findByEmail(req.getEmail());
        if (acc == null) throw new NoSuchElementException();
        String hashedPassword = passwordEncoder.encode(req.getPassword());
        boolean valid = hashedPassword.equals(acc.getPassword());
        if (!valid) throw new IllegalArgumentException();
        log.info("Login Successful for user with id " + acc.getId());
    }

    @Override
    public void addCityForAccount(Integer city_id, Integer account_id) {
        Optional<Account> optionalAccount = accountRepository.findById(account_id);
        Account account;
        if (optionalAccount.isPresent()) account = optionalAccount.get();
        else throw new NoSuchElementException();

        List<City> cityList = new ArrayList<>(account.getCities());

        Optional<City> optionalCity = cityRepository.findById(city_id);
        City city;
        if (optionalCity.isPresent()) city = optionalCity.get();
        else throw new NoSuchElementException();

        cityList.add(city);

        account.setCities(cityList);

        accountRepository.save(account);
    }

    @Override
    public void deleteCityForAccount(Integer city_id, Integer account_id) {
        Optional<Account> optionalAccount = accountRepository.findById(account_id);
        Account account;
        if (optionalAccount.isPresent()) account = optionalAccount.get();
        else throw new NoSuchElementException();

        List<City> cityList = new ArrayList<>(account.getCities());

        Optional<City> optionalCity = cityRepository.findById(city_id);
        City city;
        if (optionalCity.isPresent()) city = optionalCity.get();
        else throw new NoSuchElementException();

        cityList.removeIf(c -> c.getId().equals(city.getId()));

        account.setCities(cityList);

        accountRepository.save(account);
    }

    private Account mapRegisterRequestToAccountEntity(RegisterRequest req) {
        String hashedPassword = passwordEncoder.encode(req.getPassword());
        return new Account(req.getFirstName(), req.getLastName(), req.getEmail(), hashedPassword, new ArrayList<>());
    }
}
