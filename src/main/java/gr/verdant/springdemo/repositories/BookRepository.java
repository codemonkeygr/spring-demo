package gr.verdant.springdemo.repositories;

import gr.verdant.springdemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
