package org.spring.springboot.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.BookRepository;
import org.spring.springboot.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by mongoding on 2017/4/19.
 */
@Component
public class SimpleBookRepository implements BookRepository {

    private static final Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);
    @Override
    @Cacheable("cacheDemo")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        logger.info("我在取数据");
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}