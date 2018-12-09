package gr.verdant.springdemo.repositories;

import gr.verdant.springdemo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
