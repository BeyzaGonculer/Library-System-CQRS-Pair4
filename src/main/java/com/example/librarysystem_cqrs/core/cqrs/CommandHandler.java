package com.example.librarysystem_cqrs.core.cqrs;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}
