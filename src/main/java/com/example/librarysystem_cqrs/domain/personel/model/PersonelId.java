package com.example.librarysystem_cqrs.domain.personel.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record PersonelId(UUID value) implements Serializable {

    public PersonelId{
        Objects.requireNonNull(value, "Value for PersonelId cannot be null");
    }

    public static PersonelId generate(){
        return new PersonelId(UUID.randomUUID());
    }
}
