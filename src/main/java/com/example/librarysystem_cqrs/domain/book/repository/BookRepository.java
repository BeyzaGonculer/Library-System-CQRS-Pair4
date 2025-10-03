package com.example.librarysystem_cqrs.domain.book.repository;

import com.example.librarysystem_cqrs.domain.book.model.Book;
import com.example.librarysystem_cqrs.domain.book.model.BookId;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    Optional<Book> findById(BookId id);

    Book save(Book book);
}
