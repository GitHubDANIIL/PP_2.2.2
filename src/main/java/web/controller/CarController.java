package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImp carServiceImp;

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {

        List<String> cars = new ArrayList<>();
        for (Car car : carServiceImp.getCarList(count)) {
            cars.add(car.toString());
        }
        model.addAttribute("cars", carServiceImp.getCarList(count));
        return "cars";
    }


}
