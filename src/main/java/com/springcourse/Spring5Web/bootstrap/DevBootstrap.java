package com.springcourse.Spring5Web.bootstrap;

import com.springcourse.Spring5Web.model.Author;
import com.springcourse.Spring5Web.model.Book;
import com.springcourse.Spring5Web.repositories.AuthorRepository;
import com.springcourse.Spring5Web.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData(){
        //Crea oggetti tipo Autore e Libro
        Author luca = new Author("Luca", "Di Gianventura");
        Book fake = new Book("Finto libro di prova", "1234");
        luca.getBooks().add(fake);
        fake.getAuthors().add(luca);

        //Li salva nel database Hibernate con CRUD operations
        authorRepository.save(luca);
        bookRepository.save(fake);

        //Rod Johnson
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "23444");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
