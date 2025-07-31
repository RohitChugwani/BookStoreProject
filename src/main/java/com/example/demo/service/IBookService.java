package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BookDto;

public interface IBookService {

	BookDto addBook(BookDto bookDto);

	List<BookDto> getAllBook();

	void deleteById(Long bookId);

	BookDto findById(Long bookId);

	BookDto findByBookName(String bookName);

	BookDto updateData(Long bookId, BookDto bookDto);


}
