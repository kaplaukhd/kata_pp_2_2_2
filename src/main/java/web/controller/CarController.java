package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarController {

    private final CarServiceImp carService;

    public CarController(CarServiceImp carService){
        this.carService = carService;
    }

    @GetMapping("/car")
    public String getCar(ModelMap model, @RequestParam int count){
        List<Car> carList = carService.getCarList(count);
        model.addAttribute("cars", carList);
        return "car";
    }
}
