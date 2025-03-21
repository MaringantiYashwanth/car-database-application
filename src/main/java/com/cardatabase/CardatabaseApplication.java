package com.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cardatabase.domain.AppUser;
import com.cardatabase.domain.AppUserRepository;
import com.cardatabase.domain.Car;
import com.cardatabase.domain.CarRepository;
import com.cardatabase.domain.Owner;
import com.cardatabase.domain.OwnerRepository;



@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;
	private final AppUserRepository userRepository;
	public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository, AppUserRepository userRepository) {
		this.carRepository = carRepository;
		this.ownerRepository = ownerRepository;
		this.userRepository = userRepository;
	}
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application has started");
	}
	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		Owner owner3 = new Owner("Yashwanth", "Maringanti");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2, owner3));
		// injecting car repository into the main class to save the new car
		// object to the database.
		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
		carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner3));
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPassword = encoder.encode("password");
		userRepository.save(new AppUser("user", hashedPassword, "USER"));
		userRepository.save(new AppUser("admin", hashedPassword, "ADMIN"));
		System.out.println("password = " + hashedPassword);
		// Fetch all cars and log to console
		for (Car car: carRepository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}
	}

}
