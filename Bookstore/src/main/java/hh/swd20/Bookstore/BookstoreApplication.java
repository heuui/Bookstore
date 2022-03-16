package hh.swd20.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			
			// saving categories to database
			log.info("Save some sample books and categories"); // save to database
			Category category1 = new Category("Fiction");
			categoryRepository.save(category1);
			Category category2 = new Category("Nonfiction");
			categoryRepository.save(category2);
			Category category3 = new Category("Fantasy");
			categoryRepository.save(category3);
			Category category4 = new Category("Poetry");
			categoryRepository.save(category4);
			Category category5 = new Category("Sci-Fi");
			categoryRepository.save(category5);
			Category category6 = new Category("Mystery");
			categoryRepository.save(category6);
			Category category7 = new Category("Romance");
			categoryRepository.save(category7);
			Category category8 = new Category("Dystopian");
			categoryRepository.save(category8);
			Category category9 = new Category("Thriller");
			categoryRepository.save(category9);
			Category category10 = new Category("Drama");
			categoryRepository.save(category10);
			
			// saving books to database
			bookRepository.save(new Book("The Picture of Dorian Gray", "Oscar Wilde", 1891, "978-951-1-25774-5", 9.99, category1));
			bookRepository.save(new Book("Lord of the Flies", "William Golding", 1960, "978-951-1-27428-5", 9.90, category1));
			bookRepository.save(new Book("The Story of The Human Body", "Daniel Lieberman", 2013, "978-0-141-39995-9", 12.90, category2));
			
			// saving users to database
			User user1 = new User("user", "$2a$10$FAytVfwJRgYY6o9ZCbRn5ePi7jyW6t//8TOS15o4/eizlEAu33NGe", "bookworm00@ymail.com", "USER");
			User user2 = new User("admin", "$2a$10$O6Y2DxZShhcg8z1RS49yZeLR/mYJi3ngiaiP6Pa8CwzFyMpN1odTu", "chief.bookster@gmail.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all books"); // get from database
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
	
}
	
