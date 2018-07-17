package com.springcourse.Spring5Web.model;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(){
    }

    public Author(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    public Author(String first, String last, Set<Book> books){
        this.firstName = first;
        this.lastName = last;
        this.books = books;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName(){ return this.firstName; }
    public void setFirstName(String first){ this.firstName = first;}

    public String getLastName(){ return this.lastName; }
    public void setLastName(String last) { this.lastName = last; }

    public Set<Book> getBooks(){ return this.books; }
    public void setBooks(Set<Book> books){ this.books = books; }
}
