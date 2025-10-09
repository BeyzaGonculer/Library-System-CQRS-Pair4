package com.example.librarysystem_cqrs.application.book.mapper;

import com.example.librarysystem_cqrs.application.book.dto.BookResponse;
import com.example.librarysystem_cqrs.domain.book.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookResponseMapper {

    public BookResponse toResponse(Book book){

        return new BookResponse(
                book.getId().value(),
                book.getName(),
                book.getPageCount(),
                book.getIsbnNumber(),
                book.getTotalCopies(),
                book.getAvailableCopies()
        );
    }
}
