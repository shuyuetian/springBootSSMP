package com.mytest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mytest.pojo.Book;

import java.util.List;

public interface BookService {
    //增删改
    Boolean save(Book book);
    Boolean delete(Integer id);
    Boolean update(Book book);
    //查 单一
    Book selectById(Integer id);
    //查 全部
    List<Book> selectAll();
    //分页
    IPage<Book> getPage(Integer curretnpage,Integer pageSize);
}
