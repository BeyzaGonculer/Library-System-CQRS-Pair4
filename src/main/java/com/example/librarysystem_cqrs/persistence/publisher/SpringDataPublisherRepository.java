package com.example.librarysystem_cqrs.persistence.publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataPublisherRepository extends JpaRepository<JpaPublisherEntity , UUID> {
}
