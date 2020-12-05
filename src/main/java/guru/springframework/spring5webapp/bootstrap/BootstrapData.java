package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRepository authorRepository,
                       BookRepository bookRepository,
                       PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Publisher publisher = new Publisher();
    publisher.setName("SFG");
    publisher.setCity("NewYork");
    publisher.setState("NewYork");
    publisherRepository.save(publisher);

    Author eric = new Author("Eric","Evans");
    Book book = new Book("Domain Driven Design","123123");
    eric.getBooks().add(book);
    book.getAuthors().add(eric);
    book.setPublisher(publisher);
    publisher.getBooks().add(book);
    authorRepository.save(eric);
    bookRepository.save(book);

    Author rod = new Author("Rod","Johnson");
    Book book1 = new Book("J2EE Development","234212");
    rod.getBooks().add(book1);
    book1.getAuthors().add(rod);
    book1.setPublisher(publisher);
    publisher.getBooks().add(book1);

    authorRepository.save(rod);
    bookRepository.save(book1);
    System.out.println("Started in Bootstrap");
    System.out.println("Number of books: "+bookRepository.count());
    System.out.println("Publisher Number of books: "+publisher.getBooks().size());
  }
}
