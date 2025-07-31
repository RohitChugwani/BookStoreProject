package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BookModel;


@Repository
public interface IBookRepo extends JpaRepository<BookModel,Long>{

	Optional<BookModel> findByBookName(String bookName);

}
