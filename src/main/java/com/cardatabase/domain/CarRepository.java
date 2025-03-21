package com.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//@RepositoryRestResource(path="vehicles")
@RepositoryRestResource//(path="cars")
public interface CarRepository extends CrudRepository<Car, Long> {
	// Fetch Cars By Brand using SQL
//	@Query("select c from Car c where c.brand = ?1")
//	List<Car> findByBrandEndsWith(String brand);
	@Query(value = "SELECT * FROM car WHERE brand = :brand", nativeQuery = true)
	List<Car> fetchByBrand(@Param("brand") String brand);
	// Fetch Cars By color
	@Query("SELECT c FROM Car c WHERE c.color = :color")
	List<Car> fetchByColor(@Param("color") String color);
	// Fetch Cars By model
//	List<Car> fetchByModel(int modelYear);
	// Fetch Cars By Brand and model
//	List<Car> fetchByBrandAndModel(String brand, String model);
	// Fetch Cars By Brand or color
//	List<Car> fetchByBrandOrColor(String brand, String color);
	// fetch by brand order by model and year in ascending order
//	List<Car> fetchByBrandOrderByModelYearAsc(String brand);
	
	
}
