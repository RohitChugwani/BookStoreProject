package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.dto.BookDto;
import com.example.demo.service.IBookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	IBookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity addBook(@RequestBody BookDto bookDto) {
		BookDto book = bookService.addBook(bookDto);
		return new ResponseEntity(book, "Book added Succesfully");
	}

}
