package com.xworkz.bookstore.repository;

import com.xworkz.bookstore.entity.BookEntity;
import java.time.LocalDate;
import java.util.List;

public interface BookRepository {

    void saveBook(BookEntity bookEntity);

    BookEntity readBook(Integer bookId);

    BookEntity updateBook(BookEntity bookEntity, Integer bookId);

    BookEntity deleteBook(Integer bookId);

    BookEntity findByTitle(String title);

    BookEntity findByAuthor(String author);

    BookEntity findByPublisher(String publisher);

    BookEntity findByPrice(Double price);

    List<BookEntity> findAllBooks();

    BookEntity updatePriceById(Integer bookId, Double price);

    BookEntity updatePublisherAndPublishedDateByTitle(String title, String publisher, LocalDate publishedDate);

    BookEntity updateTitleByAuthorAndPrice(String author, Double price, String title);
}
