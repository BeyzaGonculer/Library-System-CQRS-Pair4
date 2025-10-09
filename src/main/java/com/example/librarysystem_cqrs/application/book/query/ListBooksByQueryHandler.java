package com.example.librarysystem_cqrs.application.book.query;

import com.example.librarysystem_cqrs.application.book.dto.BookResponse;
import com.example.librarysystem_cqrs.application.book.mapper.BookResponseMapper;
import com.example.librarysystem_cqrs.core.cqrs.QueryHandler;
import com.example.librarysystem_cqrs.domain.book.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListBooksByQueryHandler implements QueryHandler<ListBooksByNameQuery, List<BookResponse>> {

    private final BookRepository bookRepository;
    private final BookResponseMapper bookResponseMapper;

    public ListBooksByQueryHandler(BookRepository bookRepository, BookResponseMapper bookResponseMapper) {
        this.bookRepository = bookRepository;
        this.bookResponseMapper = bookResponseMapper;
    }

    @Override
    public List<BookResponse> handle(ListBooksByNameQuery query){
        return bookRepository.findByNameLike(query.nameLike())
                .stream()
                .map(bookResponseMapper::toResponse)
                .toList();
    }
}
