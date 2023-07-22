package web.service;

import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {

    public List<Car> carList = new ArrayList<>(List.of(
            new Car("Ford", "Red", 2000),
            new Car("Honda", "Black", 1996),
            new Car("Kia", "White", 2019),
            new Car("Infiniti", "Black", 2008),
            new Car("Toyota", "Silver", 1999)
    ));

    @Override
    public List<Car> getCarList(int count) {
        if (count == 0 || count >= 5) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
