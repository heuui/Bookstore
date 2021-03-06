package hh.swd20.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 = Jupiter
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	// testing functionality of findByAuthor() method.
	@Test
	public void findByAuthorShouldReturnBook() {
		List<Book> books = bookRepository.findByAuthor("Oscar Wilde");
		
		assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("The Picture of Dorian Gray");
	}

	// testing functionality of save() method.
	@Test
	public void createNewBook() {
		
		Book book = new Book("Moby Dick", "Herman Melville", 1851, "978-0-3939-72832", 11.50, null);
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	// testing functionality of deleteBookById() method.
	@Test
	public void deleteNewBook() {
		List<Book> books = bookRepository.findByAuthor("Oscar Wilde");
		Book book = books.get(0);
		bookRepository.delete(book);
		List<Book> newBooks = bookRepository.findByAuthor("Oscar Wilde");
		assertThat(newBooks).hasSize(0);
		
	}
	
}
