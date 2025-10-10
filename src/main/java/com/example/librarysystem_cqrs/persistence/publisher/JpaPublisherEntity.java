package com.example.librarysystem_cqrs.persistence.publisher;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="publishers")
public class JpaPublisherEntity {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name="name", nullable = false, length = 255)
    private String name;

    @Column(name="email", nullable = false )
    private String email;

    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

    @Column(name="website", nullable = false, length = 255)
    private String website;

    @Column(name="address", nullable = false, length = 500)
    private String address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
