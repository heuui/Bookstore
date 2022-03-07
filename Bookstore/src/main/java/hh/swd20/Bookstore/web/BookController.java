package hh.swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showWelcome(Model model) {
		return "welcome";
	}
	
	// show all books
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String bookList(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("categories", categoryRepository.findAll());
		return "booklist";
	}
	
	// RESTful service - get all books
	// Java Book-class list of objects to JSON-booklist
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}
	
	// RESTful service to get book by id
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return bookRepository.findById(bookId);
	}
	
	// empty form for creating new book
	@RequestMapping(value = "/addbook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }  
	
	// save new book
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:/booklist";
    }
	
	// delete book from list
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	bookRepository.deleteById(bookId);
        return "redirect:/booklist";
    }   
	
	// edit book
	@RequestMapping(value ="/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		
		return "editbook";
	}
	
	
	

}
