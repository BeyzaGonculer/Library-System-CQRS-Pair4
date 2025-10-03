package com.example.librarysystem_cqrs.domain.book.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record BookId(UUID value) implements Serializable {

    public BookId{
        Objects.requireNonNull(value, "Value for BookId cannot be null");
    }

    public static BookId generate(){
        return new BookId(UUID.randomUUID());
    }
}
