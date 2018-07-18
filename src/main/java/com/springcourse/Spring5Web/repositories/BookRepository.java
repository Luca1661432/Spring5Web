package com.springcourse.Spring5Web.repositories;

import com.springcourse.Spring5Web.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
