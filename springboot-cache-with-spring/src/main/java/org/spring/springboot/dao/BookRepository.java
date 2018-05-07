package org.spring.springboot.dao;

import org.spring.springboot.entity.Book;

/**
 * Created by fangzhipeng on 2017/4/19.
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
