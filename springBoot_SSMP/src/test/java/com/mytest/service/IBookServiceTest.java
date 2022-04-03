package com.mytest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mytest.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTest {
    @Autowired
    private IBookService iBookService;
    @Test
    void GetByid(){
        System.out.println(iBookService.getById(1));
    }
    @Test
    void Insert(){
        Book book = new Book();
        book.setName("人工智能基础技术");
        book.setDescription("学习前，需要学习python的基础技术");
        book.setType("人工智能技术");
        iBookService.save(book);
    }
    @Test
    void Update(){
        Book book = new Book();
        book.setId(3);
        book.setName("java基础技术");
        book.setDescription("学习java的基础技术");
        book.setType("大数据开发");
        iBookService.updateById(book);
    }
    @Test
    void Delete(){
        iBookService.removeById(2);
    }
    @Test
    void GetAll(){
        System.out.println(iBookService.list());
    }
    @Test
    void GetPage(){
        IPage<Book> page = new Page(1,5);
        System.out.println(iBookService.page(page));
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
