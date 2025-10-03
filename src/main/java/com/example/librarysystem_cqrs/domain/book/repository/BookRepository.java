package com.example.librarysystem_cqrs.domain.book.repository;

import com.example.librarysystem_cqrs.domain.book.model.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> findByNameLike(String name);
    List<Book> search(String isbnNumber);
    boolean existsByIsbnNumber(String isbnNumber);
    List<Book> searchCustomSql(
             String isbnNumber,
            String name,
            int authorId,
            String status
    );
    Optional<Book> findByIsbnNumber(String isbn);
}
