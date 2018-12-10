package gr.verdant.springdemo.bootstrap;

import gr.verdant.springdemo.model.Author;
import gr.verdant.springdemo.model.Book;
import gr.verdant.springdemo.model.Publisher;
import gr.verdant.springdemo.repositories.AuthorRepository;
import gr.verdant.springdemo.repositories.BookRepository;
import gr.verdant.springdemo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Chris
        Author chris = new Author("Chris", "Law");
        Publisher oReilly = new Publisher("O'Reilly", "Wisdom Street, New York, NY, USA");
        Book softwareSecurity = new Book("Software Security", "1234", oReilly);
        chris.getBooks().add(softwareSecurity);

        publisherRepository.save(oReilly);
        authorRepository.save(chris);
        bookRepository.save(softwareSecurity);

        // Carla
        Author carla = new Author("Carla", "Gonçalves");
        Publisher harlequin = new Publisher("Harlequin", "Romance Avenue, New York, NY, USA");
        Book chemistryInTheAir = new Book("Chemistry in the Air", "5678", harlequin);
        carla.getBooks().add(chemistryInTheAir);

        publisherRepository.save(harlequin);
        authorRepository.save(carla);
        bookRepository.save(chemistryInTheAir);

    }
}
