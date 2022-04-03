package com.mytest.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mytest.controller.utils.Result;
import com.mytest.pojo.Book;
import com.mytest.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public Result getAll(){
        return new Result(true,bookService.list());
    }
    //保存
    @PostMapping
    public Result save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new Result(flag,flag?"添加成功":"添加失败");
    }
    //修改
    @PutMapping
    public Result update(@RequestBody Book book){
        boolean flag = bookService.updateById(book);
        return new Result(flag,flag?"修改成功":"修改失败");
    }

    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(value = "id") Integer id){
        boolean flag = bookService.removeById(id);
        return new Result(flag,flag?"删除成功":"删除失败");
    }
    //查询单个
    @GetMapping("/{id}")
    public Result getAll(@PathVariable(value = "id") Integer id){
        return new Result(true,bookService.getById(id));
    }
    //分页
//    @GetMapping("/{currentPage}/{pageSize}")
//    public Result getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
//        IPage<Book> page = new Page<Book>(currentPage,pageSize);
//        IPage<Book> usePage = bookService.page(page);
//        //当前页比最大页码还大，显示最后一页
//        if(currentPage>usePage.getPages()){
//            page.setCurrent(usePage.getPages());
//            usePage = bookService.page(page);
//        }
//        return new Result(true,usePage);
//    }
    //查询条件
    @GetMapping("/{currentPage}/{pageSize}")
    public Result getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Book book){
        //使用查询条件
        LambdaQueryWrapper<Book> lambda = new LambdaQueryWrapper<>();
        //动态条件的拼接
        lambda.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lambda.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lambda.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        //查询
        IPage<Book> page = new Page<Book>(currentPage,pageSize);
        IPage<Book> usePage = bookService.page(page,lambda);
        //当前页比最大页码还大，显示最后一页
        if(currentPage>usePage.getPages()){
            page.setCurrent(usePage.getPages());
            usePage = bookService.page(page,lambda);
        }
        return new Result(true,usePage);
    }

}
