package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookDto;
import com.example.demo.model.BookModel;
import com.example.demo.repository.IBookRepo;

@Service
public class BookService implements IBookService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	IBookRepo bookRepo;

	@Override
	public BookDto addBook(BookDto bookDto) {
		// TODO Auto-generated method stub
		BookModel book = modelMapper.map(bookDto, BookModel.class);
		bookRepo.save(book);
		return bookDto;
	}

}
