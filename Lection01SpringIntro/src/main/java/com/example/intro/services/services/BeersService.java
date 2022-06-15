/**
 * @author dimitar
 *
 */
package com.example.intro.services.services;

import java.util.List;

import com.example.intro.services.models.BeerServiceModel;

public interface BeersService {
	
	List<BeerServiceModel> getBeers();

	void createBeer(String name); 

}
