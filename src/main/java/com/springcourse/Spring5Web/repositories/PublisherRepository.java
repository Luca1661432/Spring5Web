package com.springcourse.Spring5Web.repositories;

import com.springcourse.Spring5Web.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
