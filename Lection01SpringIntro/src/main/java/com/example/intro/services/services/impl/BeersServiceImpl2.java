/**
 * @author dimitar
 *
 */
package com.example.intro.services.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.intro.services.models.BeerServiceModel;
import com.example.intro.services.services.BeersService;

@Service
@Qualifier(value = "beersService2")
public class BeersServiceImpl2 implements BeersService{

//	@Override
//	public List<String> getBeers() {
//		
//		return null;
//	}
	
	@Override
	public List<BeerServiceModel> getBeers() {
		
		return null;
	}

	@Override
	public void createBeer(String name) {
		
	}

}
