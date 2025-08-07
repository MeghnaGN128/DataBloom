package com.xworkz.bookstore.service;

import com.xworkz.bookstore.entity.BookEntity;
import com.xworkz.bookstore.repository.BookRepository;
import com.xworkz.bookstore.repository.BookRepositoryImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository = new BookRepositoryImpl();

    private boolean isValid(BookEntity book) {
        if (book == null) {
            System.out.println("BookEntity is null");
            return false;
        }
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            System.out.println("Title is invalid");
            return false;
        }
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            System.out.println("Author is invalid");
            return false;
        }
        if (book.getPrice() == null || book.getPrice() <= 0) {
            System.out.println("Price is invalid");
            return false;
        }
        return true;
    }

    @Override
    public void saveBook(BookEntity bookEntity) {
        if (isValid(bookEntity)) {
            try {
                bookRepository.saveBook(bookEntity);
                System.out.println("Book saved successfully.");
            } catch (Exception e) {
                System.out.println("Failed to save Book.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid BookEntity, cannot save.");
        }
    }

    @Override
    public BookEntity readBook(Integer bookId) {
        return bookRepository.readBook(bookId);
    }

    @Override
    public BookEntity updateBook(BookEntity bookEntity, Integer bookId) {
        return bookRepository.updateBook(bookEntity, bookId);
    }

    @Override
    public BookEntity deleteBook(Integer bookId) {
        return bookRepository.deleteBook(bookId);
    }

    @Override
    public BookEntity findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public BookEntity findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public BookEntity findByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    @Override
    public BookEntity findByPrice(Double price) {
        return bookRepository.findByPrice(price);
    }

    @Override
    public List<BookEntity> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public BookEntity updatePriceById(Integer bookId, Double price) {
        return bookRepository.updatePriceById(bookId, price);
    }

    @Override
    public BookEntity updatePublisherAndPublishedDateByTitle(String title, String publisher, LocalDate publishedDate) {
        return bookRepository.updatePublisherAndPublishedDateByTitle(title, publisher, publishedDate);
    }

    @Override
    public BookEntity updateTitleByAuthorAndPrice(String author, Double price, String title) {
        return bookRepository.updateTitleByAuthorAndPrice(author, price, title);
    }

    @Override
    public List<Integer> findByAllBookIds() {
        return bookRepository.findByAllBookIds();
    }

    @Override
    public List<String> findByAllTitles() {
        return bookRepository.findByAllTitles();
    }

    @Override
    public List<String> findByAllAuthors() {
        return bookRepository.findByAllAuthors();
    }

    @Override
    public List<LocalDate> findByAllPublishedDates() {
        return bookRepository.findByAllPublishedDates();
    }

    @Override
    public List<Object[]> findByAllPublishersAndPrices() {
        return bookRepository.findByAllPublishersAndPrices();
    }

    @Override
    public List<Object[]> findByAllTitleAndAuthorAndPrice() {
        return bookRepository.findByAllTitleAndAuthorAndPrice();
    }
}
