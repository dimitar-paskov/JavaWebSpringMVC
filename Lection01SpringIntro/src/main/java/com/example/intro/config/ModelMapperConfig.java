/**
 * @author dimitar
 *
 */
package com.example.intro.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	private static ModelMapper mapper;
	
	static {
		mapper = new ModelMapper();
		//configure the mapper
	}
	
//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}
	
	@Bean
	public ModelMapper modelMapper() {
		return mapper;
	}

}
