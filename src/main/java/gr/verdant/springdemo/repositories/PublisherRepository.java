package gr.verdant.springdemo.repositories;

import gr.verdant.springdemo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
