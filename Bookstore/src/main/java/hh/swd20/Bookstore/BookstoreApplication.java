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

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository) {
		return (args) -> {
			
			log.info("Save some sample books"); // save to database
			brepository.save(new Book("The Picture of Dorian Gray", "Oscar Wilde", 1891, "978-951-1-25774-5", 9.99));
			brepository.save(new Book("Lord of the Flies", "William Golding", 1960, "978-951-1-27428-5", 9.90));
			brepository.save(new Book("The Story of The Human Body", "Daniel Lieberman", 2013, "978-0-141-39995-9", 12.90));

			log.info("fetch all books"); // get from database
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
	@Bean
	public CommandLineRunner categoryDemo(CategoryRepository crepository) {
		return (args) -> {
			log.info("Save some sample categories"); // save to database
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Nonfiction"));
			crepository.save(new Category("Fantasy"));

			log.info("fetch all categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
};
	}
}
	
