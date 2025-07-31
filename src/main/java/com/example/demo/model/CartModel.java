package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class CartModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cartId", nullable = false)
	Long cartId;

	@OneToOne
	@JoinColumn(name = "userId")
	UserModel user;

	@ManyToOne
	@JoinColumn(name = "bookId")
	BookModel book;

	int quantity;

	public CartModel(UserModel user, BookModel book, int quantity) {
		this.user = user;
		this.book = book;
		this.quantity = quantity;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public BookModel getBook() {
		return book;
	}

	public void setBook(BookModel book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
