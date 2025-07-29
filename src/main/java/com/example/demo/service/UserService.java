package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ResponseEntity;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.BookException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepo;
import com.example.demo.utility.JwtUtil;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepo userRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	JwtUtil jwtTokenUtil;
	
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


		@Override
		public UserDto editUserByEmail(String email_address, UserDto userDto) {
			// TODO Auto-generated method stub
			UserModel editUser = userRepo.findByEmail(email_address).orElse(null);
			if (editUser != null) {
				UserModel user = modelMapper.map(userDto, UserModel.class);
				user.setEmail(email_address);
				userRepo.save(editUser);
				return userDto;
			} else {
				throw new BookException("Email:" + email_address + " is not present");
			}
		}


		@Override
		public String loginUser(LoginDto loginDto) {
			System.out.println(loginDto.getEmail());
			// TODO Auto-generated method stub
			Optional<UserModel> user = userRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
			System.out.println(user);
			if (user.isEmpty()) {
				Optional<UserModel> userEmail = userRepo.findByEmail(loginDto.getEmail());
				Optional<UserModel> userPassword = userRepo.findByPassword(loginDto.getPassword());
				if (userEmail.isEmpty()) {
					throw new BookException("Email is incorrect,Give correct Email");
				} else if (userPassword.isEmpty()) {
					throw new BookException("Password is incorrect,Give correct password");
				}
			}
			String token = jwtTokenUtil.generateToken(loginDto);
			user.get().setIsLogin(true);
			userRepo.save(user.get());
//			System.out.println("Check the user is login or not " + user.get().getIsLogin());
			return token;
		}



		@Override
		public UserDto logout(String token) {
			// TODO Auto-generated method stub
			LoginDto userDto = jwtTokenUtil.decode(token);
			Optional<UserModel> checkUserDetails = userRepo.findByEmailAndPassword(userDto.getEmail(),
					userDto.getPassword());
			UserDto logout = modelMapper.map(checkUserDetails, UserDto.class);
			checkUserDetails.get().setIsLogin(false);
			userRepo.save(checkUserDetails.get());
			return logout;
		}


		
		
	}


