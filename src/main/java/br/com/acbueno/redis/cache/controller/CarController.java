package br.com.acbueno.redis.cache.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.redis.cache.model.Car;
import br.com.acbueno.redis.cache.services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping
	public List<Car> findAll() {
		return carService.findAll();
	}

	@GetMapping("/{id}")
	public Car findById(@PathVariable("id") final Long id) {
		return carService.findById(id);
	}

	@PostMapping
	public Car create(@RequestBody final Car car) {
		return carService.create(car);
	}

	@DeleteMapping
	public void delete(@PathVariable("id") final Long id) {
		carService.delete(id);
	}

}
