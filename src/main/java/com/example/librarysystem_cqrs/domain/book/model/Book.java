package com.example.librarysystem_cqrs.domain.book.model;

public class Book {

    private final BookId id;
    private final String name;
    private final Integer pageCount;
    private final String isbnNumber;
    private final Integer totalCopies;
    private final Integer availableCopies;

    private Book(BookId id, String name, Integer pageCount, String isbnNumber, Integer totalCopies, Integer availableCopies) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbnNumber = isbnNumber;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }
}
