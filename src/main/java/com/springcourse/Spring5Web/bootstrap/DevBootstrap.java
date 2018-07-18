package com.springcourse.Spring5Web.bootstrap;

import com.springcourse.Spring5Web.model.Author;
import com.springcourse.Spring5Web.model.Book;
import com.springcourse.Spring5Web.model.Publisher;
import com.springcourse.Spring5Web.repositories.AuthorRepository;
import com.springcourse.Spring5Web.repositories.BookRepository;
import com.springcourse.Spring5Web.repositories.PublisherRepository;
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


    private void initData(){
        Publisher pubbo = new Publisher("ProvaPub", "Casa tua");
        publisherRepository.save(pubbo);
        //Crea oggetti tipo Autore e Libro
        Author luca = new Author("Luca", "Di Gianventura");

        Book fake = new Book("Finto libro di prova", "1234", pubbo);
        luca.getBooks().add(fake);
        fake.getAuthors().add(luca);

        //Li salva nel database Hibernate con CRUD operations
        authorRepository.save(luca);
        bookRepository.save(fake);



        //Rod Johnson
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "23444", pubbo);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
