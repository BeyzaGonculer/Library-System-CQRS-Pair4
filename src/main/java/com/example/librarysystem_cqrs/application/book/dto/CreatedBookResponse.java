package com.example.librarysystem_cqrs.application.book.dto;

import java.util.UUID;

public record CreatedBookResponse (UUID id, String name, Integer pageCount, String isbnNumber, Integer totalCopies, Integer availableCopies) {
}
