package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ResponseEntity;
import com.example.demo.dto.UserDto;
import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepo;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepo userRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public  ResponseEntity add(UserDto userDto) {
		UserModel user = modelMapper.map(userDto, UserModel.class);
		userRepo.save(user);
		return new ResponseEntity(userDto,"user added successfully");

		
		
	}

}
