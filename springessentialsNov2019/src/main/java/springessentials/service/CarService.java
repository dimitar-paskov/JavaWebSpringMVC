package springessentials.service;

import java.util.List;

import springessentials.service.models.CarServiceModel;

public interface CarService {
	
	CarServiceModel save(CarServiceModel carServiceModel);
	
	List<CarServiceModel> getAllCars();

}
