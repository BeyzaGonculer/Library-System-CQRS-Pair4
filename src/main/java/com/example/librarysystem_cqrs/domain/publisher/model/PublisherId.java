package com.example.librarysystem_cqrs.domain.publisher.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record PublisherId(UUID value) implements Serializable {

    public PublisherId{
        Objects.requireNonNull(value, "Value for PublisherId cannot be null");
    }
}
