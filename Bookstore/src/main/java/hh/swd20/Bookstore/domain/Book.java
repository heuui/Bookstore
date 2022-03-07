package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	
	@Id 		// primary key
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	@ManyToOne 	// Book ManyToOne Category
	// @JsonIgnoreProperties - one way to avoid infinite loop during JSON serialization/deserialization with bidirectional relationships
	@JsonIgnoreProperties ("books")
	@JoinColumn(name="categoryId") // foreign key
	private Category category;
	
	public Book() {
		super();
		this.title = null;
		this.author = null;;
		this.year = 0;
		this.isbn = null;
		this.price = 0.0;
		this.category = null;
	}
	
	public Book(Long id, String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public Book(String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;

	}
	
	
	public Book(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Id: " + id + "Title: " + title + ", Author: " + author + ", Year: " + year + ", ISBN: " + isbn + ", Price: " + price
				+ ", Category: " + this.getCategory() + ".";
		else
			return "Id: " + id + "Title: " + title + ", Author: " + author + ", Year: " + year + ", ISBN: " + isbn + ", Price: " + price
					+ ". ";
		
		
	}
	
	
	
	

}
