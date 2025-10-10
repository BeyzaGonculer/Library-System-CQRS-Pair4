package com.example.librarysystem_cqrs.application.publisher.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreatedPublisherResponse(
        UUID id,
        String name,
        String email,
        String phoneNumber,
        String website,
        String address
) {
}
