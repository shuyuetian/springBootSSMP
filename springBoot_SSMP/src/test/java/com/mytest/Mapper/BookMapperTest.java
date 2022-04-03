package com.mytest.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mytest.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;
    @Test
    void GetByid(){
        System.out.println(bookMapper.selectById(1));
    }
    @Test
    void Insert(){
        Book book = new Book();
        book.setName("java基础技术");
        book.setDescription("学习java的基础技术");
        book.setType("面向对象技术");
        bookMapper.insert(book);
    }
    @Test
    void Update(){
        Book book = new Book();
        book.setId(3);
        book.setName("java基础技术");
        book.setDescription("学习java的基础技术");
        book.setType("java开发");
        bookMapper.updateById(book);
    }
    @Test
    void Delete(){
        Book book = new Book();
        book.setId(3);
        book.setName("java基础技术");
        book.setDescription("学习java的基础技术");
        book.setType("java开发");
        bookMapper.updateById(book);
    }
    @Test
    void GetAll(){
        System.out.println(bookMapper.selectList(null));
    }
    @Test
    void GetPage(){
        //还需要配置MP拦截器
        IPage page = new Page();
        page.setCurrent(1);
        page.setSize(5);
        System.out.println(bookMapper.selectPage(page,null));
//        List<Book> records = page.getRecords();
    }
    @Test
    void GetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","基础");
        bookMapper.selectList(qw);
    }
    @Test
    void GetBy2(){
        LambdaQueryWrapper<Book> qw2 = new LambdaQueryWrapper<>();
        qw2.like(Book::getName,"基础");
        bookMapper.selectList(qw2);
    }
}
