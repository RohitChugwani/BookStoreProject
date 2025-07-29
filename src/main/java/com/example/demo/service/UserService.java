package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ResponseEntity;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.BookException;
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
		
		
		@Override
		public List<UserDto> findAll() {
			return userRepo.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		}

		@Override
		public UserDto findById(Long Id) {
			Optional<UserModel> user = userRepo.findById(Id);
			if (user.isEmpty()) {
				throw new BookException(" User Id does not exist");
			}
			UserDto userDto = modelMapper.map(user.get(), UserDto.class);
			return userDto;
		}

		@Override
		public UserDto getUserByEmail(String email) {
			Optional<UserModel> user = userRepo.findByEmail(email);
			if (user.isEmpty()) {
				throw new BookException(" User Email does not exist");
			}
			UserDto userDto = modelMapper.map(user.get(), UserDto.class);
			return userDto;
		}

		
		
	}


