package com.xworkz.bookstore.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "book_info")

@NamedQuery(name = "BookEntity.findByTitle", query = "SELECT b FROM BookEntity b WHERE b.title = :title")
@NamedQuery(name = "BookEntity.findByAuthor", query = "SELECT b FROM BookEntity b WHERE b.author = :author")
@NamedQuery(name = "BookEntity.findByPublisher", query = "SELECT b FROM BookEntity b WHERE b.publisher = :publisher")
@NamedQuery(name = "BookEntity.findByPrice", query = "SELECT b FROM BookEntity b WHERE b.price = :price")
@NamedQuery(name = "BookEntity.findAll", query = "SELECT b FROM BookEntity b")
@NamedQuery(name = "BookEntity.updatePriceById",
        query = "UPDATE BookEntity b SET b.price = :price WHERE b.bookId = :bookId")
@NamedQuery(name = "BookEntity.updatePublisherAndPublishedDateByTitle",
        query = "UPDATE BookEntity b SET b.publisher = :publisher, b.publishedDate = :publishedDate WHERE b.title = :title")
@NamedQuery(name = "BookEntity.updateTitleByAuthorAndPrice",
        query = "UPDATE BookEntity b SET b.title = :title WHERE b.author = :author AND b.price = :price")
@NamedQuery(name = "findByAllBookIds", query = "SELECT b.bookId FROM BookEntity b")
@NamedQuery(name = "findByAllTitles", query = "SELECT b.title FROM BookEntity b")
@NamedQuery(name = "findByAllAuthors", query = "SELECT b.author FROM BookEntity b")
@NamedQuery(name = "findByAllPublishedDates", query = "SELECT b.publishedDate FROM BookEntity b")
@NamedQuery(name = "findByAllPublishersAndPrices", query = "SELECT b.publisher, b.price FROM BookEntity b")
@NamedQuery(name = "findByAllTitleAndAuthorAndPrice", query = "SELECT b.title, b.author, b.price FROM BookEntity b")

public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_publisher")
    private String publisher;

    @Column(name = "book_published_date")
    private LocalDate publishedDate;

    @Column(name = "book_price")
    private Double price;
}
