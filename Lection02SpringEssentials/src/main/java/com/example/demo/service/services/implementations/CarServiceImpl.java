/**
 * @author dimitar
 *
 */
package com.example.demo.service.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.data.models.Car;
import com.example.demo.data.repositories.CarRepository;
import com.example.demo.service.modles.CarServiceModel;
import com.example.demo.service.services.CarService;

@Service
public class CarServiceImpl implements CarService {
	
	private final ModelMapper modelMapper;
	private final CarRepository carRepository;
	
//	@Autowired
	public CarServiceImpl(ModelMapper modelMapper,CarRepository carRepository ) {
		this.modelMapper = modelMapper;
		this.carRepository = carRepository;
	}

	@Override
	public CarServiceModel  save(CarServiceModel model) {
		
		this.carRepository.save(this.modelMapper.map(model, Car.class));
		
		return model ;
		
		
	}

	@Override
	public List<CarServiceModel> getCars() {
		
		return this.carRepository.findAll()
				.stream()
				.map(c -> this.modelMapper.map(c, CarServiceModel.class))
				.collect(Collectors.toList()); 
	}

}
