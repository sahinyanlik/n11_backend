package library.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.model.Book;
import library.model.Status;
import library.repository.BookRepository;

@RestController
@RequestMapping("books")
@CrossOrigin(origins = "*")
public class BookController {

	@Autowired
	private BookRepository repository;

	@RequestMapping("/get")
	public List<Book> getBooks() {
		List<Book> books = repository.findAll();
		// List<Book> books = new ArrayList<Book>();
		// Book b = new Book();
		// Author a = new Author();
		// b.setId(1);
		// b.setName("Sürgün Ruhlar");
		// a.setId(1);
		// a.setName("Levent Yanlık");
		// b.setAuthor(a);
		// books.add(b);

		return books;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {

		if (book != null) {
			// book.setId();
			ObjectId id = new ObjectId();
			book.setId(id.getCounter());
			repository.save(book);
		}
		return book;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Book editBook(@RequestBody Book book) {
		if (book != null) {
			Book initial = repository.findById(book.getId());
			
			if(initial != null ){
				initial.setAuthor(book.getAuthor());
				initial.setName(book.getName());
				repository.save(initial);
			}
		}
		return book;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public Status deleteBook(@RequestBody Book book){
		if(book != null ){
			Book initial = repository.findById(book.getId());
			if(initial != null){
				repository.delete(initial);
				Status s = new Status();
				s.setStatus(true);
				return s;
			}
		}
		return null;
	}

}
