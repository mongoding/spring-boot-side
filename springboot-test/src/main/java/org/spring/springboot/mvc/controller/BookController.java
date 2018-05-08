package org.spring.springboot.mvc.controller;

import org.spring.springboot.dto.ResponseDTO;
import org.spring.springboot.mvc.entity.Book;
import org.spring.springboot.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Book 控制层
 * <p>
 * Created by mongoding on 27/09/2017.
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 获取 Book 列表
     * 处理 "/book" 的 GET 请求，用来获取 Book 列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseDTO<List<Book>> getBookList() {
        List<Book> books = bookService.findAll();
        return ResponseDTO.success(books);
    }

    /**
     * 获取 Book
     * 处理 "/book/{id}" 的 GET 请求，用来获取 Book 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO<Book> getBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return ResponseDTO.success(book);
    }

    /**
     * 创建 Book
     * 处理 "/book/create" 的 POST 请求，用来新建 Book 信息
     * 通过 @RequestBody 绑定实体参数，也通过 @RequestParam 传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseDTO<Book> postBook(@RequestBody Book book) {
        Book book1 = bookService.insertByBook(book);

        return ResponseDTO.success(book1);
    }

    /**
     * 更新 Book
     * 处理 "/update" 的 PUT 请求，用来更新 Book 信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseDTO<Book> putBook(@RequestBody Book book) {
        Book book1 = bookService.update(book);
        return ResponseDTO.success(book1);
    }

    /**
     * 删除 Book
     * 处理 "/book/{id}" 的 GET 请求，用来删除 Book 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseDTO<Book> deleteBook(@PathVariable Long id) {
        Book book1 = bookService.delete(id);
        return ResponseDTO.success(book1);
    }

}
