package com.example.Bookstore.domain;

public class Book {
	private String title;
	private String author;
	private int year;
	private double isbn; // is it double??
	private double price;
	
	
	public String getTitle() {		
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getIsbn() {
		return isbn;
	}
	public void setIsbn(double isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
