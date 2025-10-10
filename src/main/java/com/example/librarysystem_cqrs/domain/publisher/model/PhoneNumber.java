package com.example.librarysystem_cqrs.domain.publisher.model;

import java.util.Objects;

public record PhoneNumber(String value) {
    public PhoneNumber {
        Objects.requireNonNull(value);
        if (!value.matches("^[0-9]{10,15}$"))
            throw new IllegalArgumentException("Phone number must be 10-15 digits");
    }
}