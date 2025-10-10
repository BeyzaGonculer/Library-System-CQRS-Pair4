package com.example.librarysystem_cqrs.core.cqrs;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
