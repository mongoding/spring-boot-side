package org.spring.springboot.service;


import org.spring.springboot.domain.Book;

import java.util.List;

public interface IBookService {

    Book findBookById(int id);

    Book findBookByName(String name);

    List<Book> findBookByUserName(String userName);
}
