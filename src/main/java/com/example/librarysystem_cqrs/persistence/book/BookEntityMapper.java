package com.example.librarysystem_cqrs.persistence.book;

import com.example.librarysystem_cqrs.domain.book.model.Book;
import com.example.librarysystem_cqrs.domain.book.model.BookId;

public class BookEntityMapper {

    public JpaBookEntity toEntity(Book book)
    {
        JpaBookEntity bookEntity = new JpaBookEntity();
        bookEntity.setId(book.getId().value());
        bookEntity.setName(book.getName());
        bookEntity.setPageCount(book.getPageCount());
        bookEntity.setIsbnNumber(book.getIsbnNumber());
        bookEntity.setTotalCopies(book.getTotalCopies());
        bookEntity.setAvailableCopies(book.getAvailableCopies());
        return bookEntity;
    }

    public Book toDomain(JpaBookEntity entity)
    {
        return Book.rehydrate(
                new BookId(entity.getId()),
                entity.getName(),
                entity.getPageCount(),
                entity.getIsbnNumber(),
                entity.getTotalCopies(),
                entity.getAvailableCopies()
        );
    }
}
