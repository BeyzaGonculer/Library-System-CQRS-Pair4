package com.example.librarysystem_cqrs.interfaces.web;

import com.example.librarysystem_cqrs.application.publisher.command.CreatePublisherCommand;
import com.example.librarysystem_cqrs.application.publisher.dto.CreatedPublisherResponse;
import com.example.librarysystem_cqrs.core.cqrs.CommandHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/publishers")
@Validated
public class PublishersController {
    private final CommandHandler<CreatePublisherCommand , CreatedPublisherResponse>createPublisherCommandHandler;

    public PublishersController(CommandHandler<CreatePublisherCommand, CreatedPublisherResponse> createPublisherCommandHandler) {
        this.createPublisherCommandHandler = createPublisherCommandHandler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedPublisherResponse createPublisher(@Valid @RequestBody CreatePublisherCommand command) {
        return createPublisherCommandHandler.handle(command);
    }
}
