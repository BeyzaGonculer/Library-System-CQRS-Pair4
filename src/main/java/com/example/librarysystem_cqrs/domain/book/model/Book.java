package com.example.librarysystem_cqrs.domain.book.model;

public class Book {

    private final BookId id;
    private final String name;
    private final Integer pageCount;
    private final String isbnNumber;
    private final Integer totalCopies;
    private final Integer availableCopies;

    private Book(BookId id, String name, Integer pageCount, String isbnNumber, Integer totalCopies, Integer availableCopies) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbnNumber = isbnNumber;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public static Book create(String name, Integer pageCount, String isbnNumber, Integer totalCopies, Integer availableCopies){

        validateName(name);
        validatePageCount(pageCount);
        validateIsbnNumber(isbnNumber);
        validateTotalCopy(totalCopies);
        validateAvailableCopy(totalCopies,availableCopies);

        return new Book(BookId.generate(), name, pageCount, isbnNumber, totalCopies, availableCopies);

    }



    private static void validateName(String name){

        if(name.equals(null)){
            throw new IllegalArgumentException("Book name cannot be null");
        }
    }

    private static void validatePageCount(Integer pageCount){

        if (pageCount <= 0){
            throw new IllegalArgumentException("Page count cannot be zero and negative");
        }
    }

    private static void validateIsbnNumber(String isbnNumber){
        if(isbnNumber.length() != 8){
            throw new IllegalArgumentException("ISBN number length should be 8");
        }
    }

    private static void validateTotalCopy(Integer totalCopies){
        if (totalCopies <= 0){
            throw new IllegalArgumentException("Total copy cannot be zero and negative");
        }
    }

    private static void validateAvailableCopy(Integer totalCopies, Integer availableCopies){
        if(availableCopies > totalCopies){
            throw new IllegalArgumentException("Available copy cannot be bigger than total copy");
        }

        if (availableCopies < 0){
            throw new IllegalArgumentException("Available copy cannot be negative");
        }
    }



}
