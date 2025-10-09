package com.example.librarysystem_cqrs.application.book.query;

import com.example.librarysystem_cqrs.application.book.dto.BookResponse;
import com.example.librarysystem_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ListBooksByNameQuery(@NotBlank String nameLike) implements Query<List<BookResponse>> {

}
