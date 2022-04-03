package com.mytest.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mytest.Mapper.BookMapper;
import com.mytest.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    void GetByid(){
        System.out.println(bookService.selectById(1));
    }
    @Test
    void Insert(){
        Book book = new Book();
        book.setName("java基础技术");
        book.setDescription("学习java的基础技术");
        book.setType("操作系统");
        bookService.save(book);
    }
    @Test
    void Update(){
        Book book = new Book();
        book.setId(3);
        book.setName("java基础技术");
        book.setDescription("学习java的基础技术");
        book.setType("大数据开发");
        bookService.update(book);
    }
    @Test
    void Delete(){
        bookService.delete(2);
    }
    @Test
    void GetAll(){
        System.out.println(bookService.selectAll());
    }
    @Test
    void GetPage(){
        System.out.println(bookService.getPage(1,5));
    }
//    @Test
//    void GetBy(){
//        QueryWrapper<Book> qw = new QueryWrapper<>();
//        qw.like("name","基础");
//        bookMapper.selectList(qw);
//    }
//    @Test
//    void GetBy2(){
//        LambdaQueryWrapper<Book> qw2 = new LambdaQueryWrapper<>();
//        qw2.like(Book::getName,"基础");
//        bookMapper.selectList(qw2);
//    }
}
