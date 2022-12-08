package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("BMW", "Violet", 544));
        carList.add(new Car("Audi", "Light blue", 147));
        carList.add(new Car("Mercedes", "Blue", 200));
        carList.add(new Car("Volkswagen", "Black", 333));
        carList.add(new Car("Lada", "White", 698));
    }

    @Override
    public List<Car> getCarList(int count) {
        if (count > 5 || count < 1) {
            return this.carList;
        } else {
            return carList.stream().limit(count).toList();
        }
    }
}
