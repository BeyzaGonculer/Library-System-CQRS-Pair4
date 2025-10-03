package com.example.librarysystem_cqrs.application.book.command;

import com.example.librarysystem_cqrs.application.book.dto.CreatedBookResponse;
import com.example.librarysystem_cqrs.application.book.mapper.CreateBookMapper;
import com.example.librarysystem_cqrs.core.cqrs.CommandHandler;
import com.example.librarysystem_cqrs.domain.book.model.Book;
import com.example.librarysystem_cqrs.domain.book.repository.BookRepository;

public class CreateBookCommandHandler implements CommandHandler<CreateBookCommand, CreatedBookResponse> {

    private final BookRepository bookRepository;
    private final CreateBookMapper createBookMapper;

    public CreateBookCommandHandler(BookRepository bookRepository, CreateBookMapper createBookMapper) {
        this.bookRepository = bookRepository;
        this.createBookMapper = createBookMapper;
    }

    @Override
    public CreatedBookResponse handle(CreateBookCommand command) {

        Book book = createBookMapper.toDomain(command);
        book = bookRepository.save(book);

        return createBookMapper.toResponse(book);
    }
}
