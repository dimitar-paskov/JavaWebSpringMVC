/**
 * @author dimitar
 *
 */
package com.example.intro.beans;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperFactoryImpl implements ModelMapperFactory{

	@Override
	public ModelMapper getModelMapper() {
		
		return new ModelMapper();
	}

}
