/**
 * @author dimitar
 *
 */
package com.example.demo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
	
	

}
