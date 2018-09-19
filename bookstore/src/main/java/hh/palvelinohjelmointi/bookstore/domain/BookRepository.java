package hh.palvelinohjelmointi.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import hh.palvelinohjelmointi.bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
