package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.ResponseEntity;
import com.example.demo.dto.CartDto;


public interface ICartService {

	List<CartDto> findAll();

	CartDto findById(Long id);

	void deleteById(Long id);

	CartDto updateCartData(Long id, CartDto cartDto);

	ResponseEntity addBook(CartDto cartDto);
}
