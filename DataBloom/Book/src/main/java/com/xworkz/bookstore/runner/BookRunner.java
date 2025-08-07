package com.xworkz.bookstore.runner;

import com.xworkz.bookstore.entity.BookEntity;
import com.xworkz.bookstore.repository.BookRepository;
import com.xworkz.bookstore.repository.BookRepositoryImpl;
import com.xworkz.bookstore.service.BookService;
import com.xworkz.bookstore.service.BookServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BookRunner {
    public static void main(String[] args) {
        BookRepository repository = new BookRepositoryImpl();
        BookService bookService=new BookServiceImpl();

        // Create and save a new BookEntity
        BookEntity book = new BookEntity();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPublisher("Addison-Wesley");
        book.setPublishedDate(LocalDate.of(2018, 1, 6));
        book.setPrice(45.00);

//        repository.saveBook(book);
//        System.out.println("Book saved successfully!");

        // Example: Read entity by bookId (assuming ID 1)
//        BookEntity found = repository.readBook(1);
//        if (found != null) {
//            System.out.println("Book found: " + found);
//        } else {
//            System.out.println("No Book found with id 1");
//        }
//
//        // Example: Update entity
//        BookEntity toUpdate = new BookEntity();
//        toUpdate.setTitle("Effective Java 3rd Edition");
//        toUpdate.setAuthor("Joshua Bloch");
//        toUpdate.setPublisher("Addison-Wesley Professional");
//        toUpdate.setPublishedDate(LocalDate.of(2018, 1, 6));
//        toUpdate.setPrice(50.00);
//
//        BookEntity updated = repository.updateBook(toUpdate, 1);
//        if (updated != null) {
//            System.out.println("Update successful: " + updated);
//        } else {
//            System.out.println("Update failed for id 1");
//        }
//
//        // Example: Delete entity with id 1
//        BookEntity deleted = repository.deleteBook(1);
//        if (deleted != null) {
//            System.out.println("Deleted Book: " + deleted);
//        } else {
//            System.out.println("Deletion failed for id 1");
//        }
//
//        // Example: Find all Book entities
//        List<BookEntity> allBooks = repository.findAllBooks();
//        System.out.println("Total Book entities found: " + allBooks.size());
//        allBooks.forEach(System.out::println);
//
//        // You could continue adding more tests for your named query updates and finds here...

//        List<Integer> l1=bookService.findByAllBookIds();
//        l1.forEach(System.out::println);
//
//        List<String> l2=bookService.findByAllTitles();
//        l2.forEach(System.out::println);
//
//        List<String> l3=bookService.findByAllAuthors();
//        l3.forEach(System.out::println);
//
//        List<LocalDate> l4=bookService.findByAllPublishedDates();
//        l4.forEach(System.out::println);

//        List<Object[]> l5=bookService.findByAllPublishersAndPrices();
//        l5.forEach(a-> System.out.println(Arrays.toString(a)));

        List<Object[]> l6=bookService.findByAllTitleAndAuthorAndPrice();
        l6.forEach(b-> System.out.println(Arrays.toString(b)));
    }
}
