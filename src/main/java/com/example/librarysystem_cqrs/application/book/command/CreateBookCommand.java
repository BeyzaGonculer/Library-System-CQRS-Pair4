package com.example.librarysystem_cqrs.application.book.command;

import com.example.librarysystem_cqrs.application.book.dto.CreatedBookResponse;
import com.example.librarysystem_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateBookCommand (@NotBlank @Size(min=3,max = 255) String name,
                                 @Min(0) Integer pageCount,
                                 @NotBlank @Size(min=8,max = 8) String isbnNumber,
                                 @Min(0) Integer totalCopies,
                                 @Min(0) Integer availableCopies) implements Command<CreatedBookResponse> {


}
