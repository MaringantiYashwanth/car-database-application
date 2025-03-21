package com.cardatabase.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardatabase.domain.Car;
import com.cardatabase.domain.CarRepository;

@RestController
public class CarController {	
	private final CarRepository repository ;
	public CarController(CarRepository repository) {
		this.repository = repository;
	}
	@GetMapping("/cars")
	public Iterable<Car> getCars() {
		// Fetch and return cars
		return repository.findAll();
	}
}
