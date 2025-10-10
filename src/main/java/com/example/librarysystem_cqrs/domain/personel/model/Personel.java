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


    private static void validateFirstName(String firstName){

        if(firstName.equals(null)){
            throw new IllegalArgumentException("First name cannot be null");
        }
    }

    private static void validateLastName(String lastName){

        if(lastName.equals(null)){
            throw new IllegalArgumentException("Last name cannot be null");
        }
    }

    private static void validateEmail(String email){

        if(email.equals(null)){
            throw new IllegalArgumentException("Email address cannot be null");
        }
        if(!email.contains("@")){
            throw new IllegalArgumentException("Email address must be contain @");
        }
    }

    private static void validatePhoneNumber(String phoneNumber){

        if(phoneNumber.equals(null)){
            throw new IllegalArgumentException("Phone number cannot be null");
        }

        if (phoneNumber.length() != 10){
            throw new IllegalArgumentException("Phone number length should be 10 (Ex: (546) 456 87 98");
        }
    }


}

