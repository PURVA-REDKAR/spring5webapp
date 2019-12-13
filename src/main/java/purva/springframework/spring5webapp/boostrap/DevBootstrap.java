package purva.springframework.spring5webapp.boostrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import purva.springframework.spring5webapp.model.Author;
import purva.springframework.spring5webapp.model.Book;
import purva.springframework.spring5webapp.model.Publisher;
import purva.springframework.spring5webapp.repositories.AuthorRepository;
import purva.springframework.spring5webapp.repositories.BookRepository;
import purva.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {
        Publisher pub = new Publisher("Pub1","rochester");
        Author eva = new Author("Eric", "Evans");
        Book bk = new Book(pub,"Design","1234");
        eva.getBook().add(bk);
        bk.getAuthors().add(eva);
        authorRepository.save(eva);
        bookRepository.save(bk);
        publisherRepository.save(pub);

        Publisher pub1 = new Publisher("memba","rochester");
        Author rood = new Author("rod", "jhonson");
        Book bk1 = new Book(pub1,"jeee","1234");

        bk1.setPublisher(pub1);
        rood.getBook().add(bk1);
        bk1.getAuthors().add(rood);
        authorRepository.save(rood);
        bookRepository.save(bk1);
        publisherRepository.save(pub1);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
