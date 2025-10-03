package com.example.librarysystem_cqrs.domain.category.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record CategoryId(UUID value) implements Serializable {
    public CategoryId{
        Objects.requireNonNull(value, "Value for CategoryId cannot be null");
    }
}
