package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.dto.UserDto;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello" ;		
	}
	
	@PostMapping("/insertUser")
	public ResponseEntity AddAddressDetails(@RequestBody UserDto userDto) {
		ResponseEntity user = userService.add(userDto);
		return new ResponseEntity(user, "User added succesfully");
	}
	
	@GetMapping("/findAllUser")
	public ResponseEntity findAllDetails() {
		List<UserDto> userList = userService.findAll();
		return new ResponseEntity(userList, "All user list");
	}

	@GetMapping("/getUser/{Id}")
	public ResponseEntity FindById(@PathVariable Long Id) {
		UserDto user = userService.findById(Id);
		return new ResponseEntity(user, "Find successfully");
	}

	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity getDataByEmail(@PathVariable String email) {
		UserDto user = userService.getUserByEmail(email);
		return new ResponseEntity(user, "Find successfully");
	}


}
