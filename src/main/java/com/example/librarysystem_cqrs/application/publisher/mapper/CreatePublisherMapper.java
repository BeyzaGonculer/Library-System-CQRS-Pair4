package com.example.librarysystem_cqrs.application.publisher.mapper;

import com.example.librarysystem_cqrs.application.publisher.command.CreatePublisherCommand;
import com.example.librarysystem_cqrs.application.publisher.dto.CreatedPublisherResponse;
import com.example.librarysystem_cqrs.domain.publisher.model.Email;
import com.example.librarysystem_cqrs.domain.publisher.model.PhoneNumber;
import com.example.librarysystem_cqrs.domain.publisher.model.Publisher;
import org.springframework.stereotype.Component;


@Component
public class CreatePublisherMapper {

    public Publisher toDomain(CreatePublisherCommand command){
        return Publisher.create(command.name(), new Email(command.email()), new PhoneNumber(command.phoneNumber()), command.website(), command.address());

    }

    public CreatedPublisherResponse toResponse(Publisher publisher){
        return  new CreatedPublisherResponse(publisher.getId().value(), publisher.getName(), publisher.getEmail().value(),publisher.getPhoneNumber().value(), publisher.getWebsite(), publisher.getAddress());
    }
}
