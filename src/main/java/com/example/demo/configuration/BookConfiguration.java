package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.modelmapper.ModelMapper;

@Configuration
public class BookConfiguration {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
