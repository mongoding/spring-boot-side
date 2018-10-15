package org.spring.springboot.dao;

import org.spring.springboot.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Book 数据持久层操作接口
 * <p>
 * Created by mongoding on 09/10/2017.
 */
@Component
public class BookRepository  {

    public static Map<Long, Book> map = new HashMap<>();



    public  Book save(Book book){
        map.put(book.getId(), book);
        return book;
    }

    public List<Book> findAll(){
        return new ArrayList<>(map.values());
    }

    public Book findById(Long id){
        return map.get(id);
    }

    public Book delete(Long id){
        return map.remove(id);
    }

}
