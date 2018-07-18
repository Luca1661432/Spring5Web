package com.springcourse.Spring5Web.repositories;


import com.springcourse.Spring5Web.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
