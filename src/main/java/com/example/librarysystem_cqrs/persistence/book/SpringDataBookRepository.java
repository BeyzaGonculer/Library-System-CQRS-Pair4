package com.example.librarysystem_cqrs.persistence.book;

import com.example.librarysystem_cqrs.domain.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SpringDataBookRepository extends JpaRepository<JpaBookEntity, UUID> {

    List<JpaBookEntity> findByNameContainingIgnoreCase(String name);

    List<JpaBookEntity> findByIsbnNumberContainingIgnoreCase(String isbnNumber);

    boolean existsByIsbnNumber(String isbnNumber);

    @Query("""
        SELECT b 
        FROM JpaBookEntity b
        WHERE (:isbnNumber IS NULL OR b.isbnNumber LIKE %:isbnNumber%)
          AND (:name IS NULL OR LOWER(b.name) LIKE LOWER(CONCAT('%', :name, '%')))
          AND (:authorId = 0 OR b.author.id = :authorId)
          AND (:status IS NULL OR b.status = :status)
    """)
    List<JpaBookEntity> searchCustom(
            @Param("isbnNumber") String isbnNumber,
            @Param("name") String name,
            @Param("authorId") int authorId,
            @Param("status") String status
    );
}
