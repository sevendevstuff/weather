package com.stefan.weather.services;

import com.stefan.weather.db.Car;
import com.stefan.weather.repositories.CarRepository;
import com.stefan.weather.requests.CarRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository repository;

    @Override
    public Integer addCar(CarRequest request) {
        Car car = repository.save(mapCarRequestToCarEntity(request));
        return car.getId();
    }

    @Override
    public Integer editCar(CarRequest request, Integer id) {
        Optional<Car> carOptional = repository.findById(id);
        if (carOptional.isEmpty()) throw new EntityNotFoundException("Car at provided id not found");
        carOptional.get().merge(mapCarRequestToCarEntity(request));
        repository.save(carOptional.get());
        return carOptional.get().getId();
    }

    @Override
    public void deleteCar(Integer id) {
        repository.deleteById(id);
    }

    private Car mapCarRequestToCarEntity(CarRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        TemporalAccessor accessor = formatter.parse(request.getFabricationYear());

        return new Car(request.getDoorNumber(), request.getName(), LocalDate.of(accessor.get(ChronoField.YEAR), 1, 1));
    }
}
