package springessentials.service.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springessentials.data.models.Car;
import springessentials.data.repositories.CarRepository;
import springessentials.service.CarService;
import springessentials.service.models.CarServiceModel;

@Service
public class CarServiceImpl implements CarService{
	
	private final ModelMapper modelMapper;
	private final CarRepository carRepository;
	
	@Autowired
	public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository) {
		this.modelMapper = modelMapper;
		this.carRepository = carRepository;
	}

	@Override
	public CarServiceModel save(CarServiceModel carServiceModel) {
		
		Car car = carRepository.save(modelMapper.map(carServiceModel, Car.class));
		carServiceModel.setId(car.getId());
		
		return carServiceModel;
		
	}

	@Override
	public List<CarServiceModel> getAllCars() {
		return carRepository.findAll()
				.stream()
				.map(c -> modelMapper.map(c, CarServiceModel.class))
				.collect(Collectors.toList());
		
	}

}
