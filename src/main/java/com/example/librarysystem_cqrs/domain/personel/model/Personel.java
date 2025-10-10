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

    public PersonelId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }



    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}

