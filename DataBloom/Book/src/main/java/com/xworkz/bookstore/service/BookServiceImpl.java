package com.xworkz.bookstore.service;

import com.xworkz.bookstore.entity.BookEntity;
import com.xworkz.bookstore.repository.BookRepository;
import com.xworkz.bookstore.repository.BookRepositoryImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

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
        if (bookId == null || bookId <= 0) {
            System.out.println("Invalid bookId");
            return null;
        }
        return bookRepository.readBook(bookId);
    }

    @Override
    public BookEntity updateBook(BookEntity bookEntity, Integer bookId) {
        if (isValid(bookEntity) && bookId != null && bookId > 0) {
            return bookRepository.updateBook(bookEntity, bookId);
        }
        System.out.println("Invalid input for updateBook");
        return null;
    }

    @Override
    public BookEntity deleteBook(Integer bookId) {
        if (bookId == null || bookId <= 0) {
            System.out.println("Invalid bookId for deletion");
            return null;
        }
        return bookRepository.deleteBook(bookId);
    }

    @Override
    public BookEntity findByTitle(String title) {
        if (title == null || title.isEmpty()) {
            System.out.println("Invalid title");
            return null;
        }
        return bookRepository.findByTitle(title);
    }

    @Override
    public BookEntity findByAuthor(String author) {
        if (author == null || author.isEmpty()) {
            System.out.println("Invalid author");
            return null;
        }
        return bookRepository.findByAuthor(author);
    }

    @Override
    public BookEntity findByPublisher(String publisher) {
        if (publisher == null || publisher.isEmpty()) {
            System.out.println("Invalid publisher");
            return null;
        }
        return bookRepository.findByPublisher(publisher);
    }

    @Override
    public BookEntity findByPrice(Double price) {
        if (price == null || price <= 0) {
            System.out.println("Invalid price");
            return null;
        }
        return bookRepository.findByPrice(price);
    }

    @Override
    public List<BookEntity> findAllBooks() {
        List<BookEntity> list = bookRepository.findAllBooks();
        return list != null ? list : Collections.emptyList();
    }

    @Override
    public BookEntity updatePriceById(Integer bookId, Double price) {
        if (bookId == null || bookId <= 0 || price == null || price <= 0) {
            System.out.println("Invalid input to updatePriceById");
            return null;
        }
        return bookRepository.updatePriceById(bookId, price);
    }

    @Override
    public BookEntity updatePublisherAndPublishedDateByTitle(String title, String publisher, LocalDate publishedDate) {
        if (title == null || title.isEmpty() || publisher == null || publisher.isEmpty() || publishedDate == null) {
            System.out.println("Invalid input to updatePublisherAndPublishedDateByTitle");
            return null;
        }
        return bookRepository.updatePublisherAndPublishedDateByTitle(title, publisher, publishedDate);
    }

    @Override
    public BookEntity updateTitleByAuthorAndPrice(String author, Double price, String title) {
        if (author == null || author.isEmpty() || price == null || price <= 0 || title == null || title.isEmpty()) {
            System.out.println("Invalid input to updateTitleByAuthorAndPrice");
            return null;
        }
        return bookRepository.updateTitleByAuthorAndPrice(author, price, title);
    }
}
