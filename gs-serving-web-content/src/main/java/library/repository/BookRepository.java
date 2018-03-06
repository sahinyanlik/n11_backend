package library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import library.model.Book;


public interface BookRepository extends MongoRepository<Book, String>{
	public Book findByName(String name);
	public Book findById(int id);
}
