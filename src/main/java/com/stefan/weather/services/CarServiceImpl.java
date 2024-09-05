package com.stefan.weather.services;

import com.stefan.weather.db.Car;
import com.stefan.weather.repositories.CarRepository;
import com.stefan.weather.requests.CarRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository repository;

    @Override
    public Integer addCar(CarRequest request) {
        Car car = repository.save(mapCarRequestToCarEntity(request));
        return car.getId();
    }

    private Car mapCarRequestToCarEntity(CarRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        TemporalAccessor accessor = formatter.parse(request.getFabricationYear());

        return new Car(request.getDoorNumber(), request.getName(), LocalDate.of(accessor.get(ChronoField.YEAR), 1, 1));
    }
}
