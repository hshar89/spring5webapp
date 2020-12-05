package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public BootstrapData(AuthorRepository authorRepository,
                       BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author("Eric","Evans");
    Book book = new Book("Domain Driven Design","123123");
    eric.getBooks().add(book);
    book.getAuthors().add(eric);
    authorRepository.save(eric);
    bookRepository.save(book);

    Author rod = new Author("Rod","Johnson");
    Book book1 = new Book("J2EE Development","234212");
    rod.getBooks().add(book1);
    book1.getAuthors().add(rod);
    authorRepository.save(rod);
    bookRepository.save(book1);
    System.out.println("Started in Bootstrap");
    System.out.println("Number of books: "+bookRepository.count());
  }
}
