/**
 * @author dimitar
 *
 */
package com.example.intro.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.intro.data.models.Beer;
import com.example.intro.data.repositories.BeersRepository;
import com.example.intro.services.models.BeerServiceModel;
import com.example.intro.services.services.BeersService;

@Service
//@Scope(value = "prototype")
@Qualifier(value = "beersService1")
public class BeersServiceImpl implements BeersService{
	
//	private final ModelMapper modelMapper;
	
//	public BeersServiceImpl(ModelMapperFactory modelMapperFactory) {
//		this.modelMapper = modelMapperFactory.getModelMapper();
//	}
	
//	public BeersServiceImpl(ModelMapper modelMapper) {
//		this.modelMapper = modelMapper;
//	}
	
	
	
//	private static List<String> beers;
//	static {
//		beers = new ArrayList<>();
//		beers.add("Zagorka");
//		beers.add("Burgasko");
//	}
//	
//	public BeersServiceImpl() {
//	
//	}
	private final BeersRepository beersRepository;
	private ModelMapper mapper; 
	
	public BeersServiceImpl(ModelMapper mapper, BeersRepository beersRepository) {
		this.mapper = mapper;
		this.beersRepository = beersRepository;
	}

	@Override
	public List<BeerServiceModel> getBeers() {
						
		return beersRepository.findAll()
				.stream()
				.map(beer -> mapper.map(beer, BeerServiceModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public void createBeer(String name) {
		Beer beer = new Beer();
		beer.setName(name);
		beersRepository.saveAndFlush(beer);
	}

}
