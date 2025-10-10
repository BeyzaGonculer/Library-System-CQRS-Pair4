package com.example.librarysystem_cqrs.application.publisher.command;

import com.example.librarysystem_cqrs.application.publisher.dto.CreatedPublisherResponse;
import com.example.librarysystem_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePublisherCommand(
        @NotBlank @Size(min=3,max = 255) String name,
        @NotBlank String email,
        @NotBlank String phoneNumber,
        @NotBlank String website,
        @NotBlank String address
) implements Command<CreatedPublisherResponse> {
}
