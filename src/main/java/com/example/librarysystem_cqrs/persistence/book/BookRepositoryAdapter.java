package com.example.librarysystem_cqrs.persistence.book;

import com.example.librarysystem_cqrs.domain.book.model.Book;
import com.example.librarysystem_cqrs.domain.book.model.BookId;
import com.example.librarysystem_cqrs.domain.book.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryAdapter implements BookRepository {

    private final SpringDataBookRepository repository;
    private final BookEntityMapper bookEntityMapper;

    public BookRepositoryAdapter(SpringDataBookRepository repository, BookEntityMapper bookEntityMapper) {
        this.repository = repository;
        this.bookEntityMapper = bookEntityMapper;
    }

    @Override
    public List<Book> findByNameLike(String name) {
        return repository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(bookEntityMapper::toDomain)
                .toList();
    }


    @Override
    public List<Book> search(String isbnNumber) {
        return repository.findByIsbnNumberContainingIgnoreCase(isbnNumber)
                .stream()
                .map(bookEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByIsbnNumber(String isbnNumber) {
        return repository.existsByIsbnNumber(isbnNumber);
    }

    @Override
    public List<Book> searchCustomSql(String isbnNumber, String name, int authorId, String status) {
        return repository.searchCustom(isbnNumber, name, authorId, status)
                .stream()
                .map(bookEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Book> findById(BookId id) {
        return repository
                .findById(id.value())
                .map(bookEntityMapper::toDomain);
    }

    @Override
    public Book save(Book book) {
        JpaBookEntity entity = bookEntityMapper.toEntity(book);
        entity = repository.save(entity);
        return bookEntityMapper.toDomain(entity);
    }
}
