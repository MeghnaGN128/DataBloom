package com.xworkz.bookstore.repository;

import com.xworkz.bookstore.entity.BookEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("x-workz");

    @Override
    public void saveBook(BookEntity bookEntity) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(bookEntity);
            tx.commit();
            System.out.println("Book saved successfully");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }

    @Override
    public BookEntity readBook(Integer bookId) {
        EntityManager em = null;
        BookEntity book = null;
        try {
            em = entityManagerFactory.createEntityManager();
            book = em.find(BookEntity.class, bookId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return book;
    }

    @Override
    public BookEntity updateBook(BookEntity entity, Integer bookId) {
        EntityManager em = null;
        EntityTransaction tx = null;
        BookEntity book = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            book = em.find(BookEntity.class, bookId);
            if (book != null) {
                book.setTitle(entity.getTitle());
                book.setAuthor(entity.getAuthor());
                book.setPublisher(entity.getPublisher());
                book.setPublishedDate(entity.getPublishedDate());
                book.setPrice(entity.getPrice());
                em.merge(book);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return book;
    }

    @Override
    public BookEntity deleteBook(Integer bookId) {
        EntityManager em = null;
        EntityTransaction tx = null;
        BookEntity book = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            book = em.find(BookEntity.class, bookId);
            if (book != null) {
                em.remove(book);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return book;
    }

    @Override
    public BookEntity findByTitle(String title) {
        EntityManager em = null;
        BookEntity book = null;
        try {
            em = entityManagerFactory.createEntityManager();
            book = em.createNamedQuery("BookEntity.findByTitle", BookEntity.class)
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No book found with title: " + title);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return book;
    }

    @Override
    public BookEntity findByAuthor(String author) {
        EntityManager em = null;
        BookEntity book = null;
        try {
            em = entityManagerFactory.createEntityManager();
            book = em.createNamedQuery("BookEntity.findByAuthor", BookEntity.class)
                    .setParameter("author", author)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No book found with author: " + author);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return book;
    }

    @Override
    public BookEntity findByPublisher(String publisher) {
        EntityManager em = null;
        BookEntity book = null;
        try {
            em = entityManagerFactory.createEntityManager();
            book = em.createNamedQuery("BookEntity.findByPublisher", BookEntity.class)
                    .setParameter("publisher", publisher)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No book found with publisher: " + publisher);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return book;
    }

    @Override
    public BookEntity findByPrice(Double price) {
        EntityManager em = null;
        BookEntity book = null;
        try {
            em = entityManagerFactory.createEntityManager();
            book = em.createNamedQuery("BookEntity.findByPrice", BookEntity.class)
                    .setParameter("price", price)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No book found with price: " + price);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return book;
    }

    @Override
    public List<BookEntity> findAllBooks() {
        EntityManager em = null;
        List<BookEntity> books = null;
        try {
            em = entityManagerFactory.createEntityManager();
            books = em.createNamedQuery("BookEntity.findAll", BookEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return books;
    }

    @Override
    public BookEntity updatePriceById(Integer bookId, Double price) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updated = em.createNamedQuery("BookEntity.updatePriceById")
                    .setParameter("price", price)
                    .setParameter("bookId", bookId)
                    .executeUpdate();
            tx.commit();
            return em.find(BookEntity.class, bookId);
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return null;
    }

    @Override
    public BookEntity updatePublisherAndPublishedDateByTitle(String title, String publisher, LocalDate publishedDate) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updated = em.createNamedQuery("BookEntity.updatePublisherAndPublishedDateByTitle")
                    .setParameter("publisher", publisher)
                    .setParameter("publishedDate", publishedDate)
                    .setParameter("title", title)
                    .executeUpdate();
            tx.commit();
            return em.createNamedQuery("BookEntity.findByTitle", BookEntity.class)
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return null;
    }

    @Override
    public BookEntity updateTitleByAuthorAndPrice(String author, Double price, String title) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updated = em.createNamedQuery("BookEntity.updateTitleByAuthorAndPrice")
                    .setParameter("title", title)
                    .setParameter("author", author)
                    .setParameter("price", price)
                    .executeUpdate();
            tx.commit();
            return em.createNamedQuery("BookEntity.findByTitle", BookEntity.class)
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return null;
    }
}
