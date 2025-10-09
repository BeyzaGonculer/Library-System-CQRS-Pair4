package com.example.librarysystem_cqrs.application.book.query;

import com.example.librarysystem_cqrs.application.book.dto.BookResponse;
import com.example.librarysystem_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

public record ListBooksQuery(
        @Min(0) Integer pageIndex,
        @Max(1) Integer pageSize
) implements Query<List<BookResponse>> {

}
