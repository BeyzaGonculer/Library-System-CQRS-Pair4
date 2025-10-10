package com.example.librarysystem_cqrs.persistence.publisher;

import com.example.librarysystem_cqrs.domain.publisher.model.Publisher;
import com.example.librarysystem_cqrs.domain.publisher.repository.PublisherRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PublisherRepositoryAdapter implements PublisherRepository {

    private final SpringDataPublisherRepository repository;
    private final PublisherEntityMapper mapper;

    public PublisherRepositoryAdapter(SpringDataPublisherRepository repository, PublisherEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Publisher save(Publisher publisher) {
        JpaPublisherEntity entity =mapper.toEntity(publisher);
        entity=repository.save(entity);
        return mapper.toDomain(entity);
    }
}
