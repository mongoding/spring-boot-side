package org.spring.springboot.service.impl;

import org.spring.springboot.domain.Book;
import org.spring.springboot.dao.BookRepository;
import org.spring.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Book 业务层实现
 * <p>
 * Created by mongoding on 30/09/2017.
 */
@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService {

    public static AtomicLong id = new AtomicLong();

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        book.setId(id.getAndIncrement());
        return bookRepository.save(book);
    }

    @CachePut(key = "#p0.id")
    @Override
    public Book update(Book book) {
        System.out.println(" call update method ");
        return bookRepository.save(book);
    }

    @CacheEvict(key = "#p0")
    @Override
    public Book delete(Long id) {
        System.out.println(" call delete method ");
        Book book = bookRepository.findById(id);
        bookRepository.delete(book.getId());
        return book;
    }

    @Cacheable(key = "#p0")
    @Override
    public Book findById(Long id) {
        System.out.println(" call findById method ");
        return bookRepository.findById(id);
    }
}
