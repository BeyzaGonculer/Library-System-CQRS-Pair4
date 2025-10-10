package com.example.librarysystem_cqrs.domain.publisher.repository;


import com.example.librarysystem_cqrs.domain.publisher.model.Publisher;

public interface PublisherRepository {

    Publisher save(Publisher publisher);
}
