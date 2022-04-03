package com.mytest.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mytest.pojo.Book;
import com.mytest.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//老版本
//@RestController
@RequestMapping("/book")
public class BookController2 {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }
    //保存
    @PutMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }
    //修改
    @PostMapping
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }
    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable(value = "id") Integer id){
        return bookService.removeById(id);
    }
    //查询单个
    @GetMapping("/{id}")
    public Book getAll(@PathVariable(value = "id") Integer id){
        return bookService.getById(id);
    }
    //分页
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<Book> page = new Page<Book>(currentPage,pageSize);
        return bookService.page(page);
    }

}
