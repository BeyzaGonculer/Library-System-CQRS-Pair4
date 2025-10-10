package com.example.librarysystem_cqrs.domain.personel.model;

public class Personel {

    private final PersonelId id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Personel(PersonelId id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

