/**
 * @author dimitar
 *
 */
package com.example.demo.service.services;

import java.util.List;

import com.example.demo.service.modles.CarServiceModel;

public interface CarService {
	
	CarServiceModel save(CarServiceModel model);
	
	List<CarServiceModel> getCars();

}
