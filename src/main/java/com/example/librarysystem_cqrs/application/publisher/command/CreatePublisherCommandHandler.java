package com.example.librarysystem_cqrs.application.publisher.command;

import com.example.librarysystem_cqrs.application.publisher.dto.CreatedPublisherResponse;
import com.example.librarysystem_cqrs.application.publisher.mapper.CreatePublisherMapper;
import com.example.librarysystem_cqrs.core.cqrs.CommandHandler;
import com.example.librarysystem_cqrs.domain.publisher.model.Publisher;
import com.example.librarysystem_cqrs.domain.publisher.repository.PublisherRepository;
import org.springframework.stereotype.Component;


@Component
public class CreatePublisherCommandHandler  implements CommandHandler<CreatePublisherCommand, CreatedPublisherResponse> {

    private final PublisherRepository publisherRepository;
    private final CreatePublisherMapper publisherMapper;

    public CreatePublisherCommandHandler(PublisherRepository publisherRepository, CreatePublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    @Override
    public CreatedPublisherResponse handle(CreatePublisherCommand command) {
        Publisher publisher = publisherMapper.toDomain(command);
        publisher=publisherRepository.save(publisher);
        return publisherMapper.toResponse(publisher);
    }
}
