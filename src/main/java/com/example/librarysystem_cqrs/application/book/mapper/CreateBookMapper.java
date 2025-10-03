package com.example.librarysystem_cqrs.application.book.mapper;

import com.example.librarysystem_cqrs.application.book.command.CreateBookCommand;
import com.example.librarysystem_cqrs.application.book.dto.BookResponse;
import com.example.librarysystem_cqrs.application.book.dto.CreatedBookResponse;
import com.example.librarysystem_cqrs.domain.book.model.Book;
import com.example.librarysystem_cqrs.domain.book.model.BookId;
import com.example.librarysystem_cqrs.persistence.book.JpaBookEntity;

public class CreateBookMapper {



    public Book toDomain(CreateBookCommand command)
    {
        return Book.create(
                        command.name(),
                        command.pageCount(),
                        command.isbnNumber(),
                        command.totalCopies(),
                        command.availableCopies()
                );
    }

    public CreatedBookResponse toResponse(Book book)
    {


        return new CreatedBookResponse(
                book.getId().value(),
                book.getName(),
                book.getPageCount(),
                book.getIsbnNumber(),
                book.getTotalCopies(),
                book.getAvailableCopies()
        );
    }
}
