package ru.artemagaev.testproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.artemagaev.testproject.entity.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    void delete(Book book);

    Book findOne(String id);

    Iterable<Book> findAll();

    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    List<Book> findByTitle(String title);
}
