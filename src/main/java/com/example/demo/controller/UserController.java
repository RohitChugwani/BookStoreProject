package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
