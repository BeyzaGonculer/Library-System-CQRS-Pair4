package com.example.librarysystem_cqrs.persistence.publisher;


import com.example.librarysystem_cqrs.domain.publisher.model.Email;
import com.example.librarysystem_cqrs.domain.publisher.model.PhoneNumber;
import com.example.librarysystem_cqrs.domain.publisher.model.Publisher;
import com.example.librarysystem_cqrs.domain.publisher.model.PublisherId;
import org.springframework.stereotype.Component;

@Component
public class PublisherEntityMapper {

    public JpaPublisherEntity toEntity(Publisher publisher)
    {
        JpaPublisherEntity publisherEntity = new JpaPublisherEntity();
        publisherEntity.setId(publisher.getId().value());
        publisherEntity.setName(publisher.getName());
        publisherEntity.setEmail(publisher.getEmail().value());
        publisherEntity.setPhoneNumber(publisher.getPhoneNumber().value());
        publisherEntity.setWebsite(publisher.getWebsite());
        publisherEntity.setAddress(publisher.getAddress());
        return publisherEntity;
    }

    public Publisher toDomain(JpaPublisherEntity entity)
    {
        return Publisher.rehydrate(
                new PublisherId(entity.getId()),
                entity.getName(),
                new Email(entity.getEmail()),
                new PhoneNumber(entity.getPhoneNumber()),
                entity.getWebsite(),
                entity.getAddress()
        );
    }
}
