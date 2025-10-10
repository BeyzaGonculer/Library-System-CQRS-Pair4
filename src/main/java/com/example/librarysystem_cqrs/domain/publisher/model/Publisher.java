package com.example.librarysystem_cqrs.domain.publisher.model;


import java.util.Objects;

public class Publisher {
    private final PublisherId id;
    private String name;
    private Email email;
    private PhoneNumber phoneNumber;
    private String website;
    private String address;

    private Publisher(PublisherId id, String name, Email email, PhoneNumber phoneNumber, String website, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.address = address;
    }
    public static Publisher create(String name, Email email, PhoneNumber phoneNumber, String website, String address)
    {
        validateName(name);
        validateEmail(email);
        validatePhoneNumber(phoneNumber);
        validateWebsite(website);
        validateAddress(address);
        return new Publisher(PublisherId.generate(), name, email, phoneNumber, website , address);
    }

    public static Publisher rehydrate(PublisherId id,String name, Email email, PhoneNumber phoneNumber, String website, String address)
    {
        return new Publisher(id, name, email, phoneNumber, website ,address);
    }


    private static void validateName(String name)
    {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");

        if(name.length() >= 255)
            throw new IllegalArgumentException("Name length must be less than 255 characters");
    }

    private static void validateEmail(Email email) {
        if (email == null)
            throw new IllegalArgumentException("Publisher email cannot be null");
        // Email regex kontrolü Email Value Object içinde zaten yapılıyor
    }

    private static void validatePhoneNumber(PhoneNumber phoneNumber) {
        if (phoneNumber == null)
            throw new IllegalArgumentException("Publisher phone number cannot be null");
        // PhoneNumber Value Object içinde format validasyonu var
    }

    private static void validateWebsite(String website) {
        if (website == null || website.isBlank()) return;

        if (!website.startsWith("http://") && !website.startsWith("https://"))
            throw new IllegalArgumentException("Website must start with http:// or https://");

        if (website.length() > 255)
            throw new IllegalArgumentException("Website URL too long");
    }

    private static void validateAddress(String address) {
        if (address == null || address.isBlank()) return;

        if (address.length() > 500)
            throw new IllegalArgumentException("Address cannot exceed 500 characters");
    }


    public void rename(String newName) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Publisher name cannot be null or blank");
        }
        if (name.length() > 255) {
            throw new IllegalArgumentException("Publisher name must be less than 255 characters");
        }
        this.name = name.trim();
    }

    public void changeEmail(Email newEmail) {
        Objects.requireNonNull(email, "Email cannot be null");
        this.email = email;
    }

    public void updatePhoneNumber(PhoneNumber newPhoneNumber) {
        Objects.requireNonNull(phoneNumber, "Phone number cannot be null");
        this.phoneNumber = phoneNumber;
    }

    public void updateWebsite(String newWebsite) {
        if (website != null && !website.isBlank()) {
            if (!website.startsWith("http://") && !website.startsWith("https://")) {
                throw new IllegalArgumentException("Website must start with http:// or https://");
            }
            if (website.length() > 255) {
                throw new IllegalArgumentException("Website URL too long");
            }
            this.website = website.trim();
        } else {
            this.website = null;
        }
    }

    public void updateAddress(String newAddress) {
        if (address != null && !address.isBlank()) {
            if (address.length() > 500) {
                throw new IllegalArgumentException("Address cannot exceed 500 characters");
            }
            this.address = address.trim();
        } else {
            this.address = null;
        }
    }



    public PublisherId getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Email getEmail() {
        return email;
    }
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    public String getWebsite() {
        return website;
    }
    public String getAddress() {
        return address;
    }

}
