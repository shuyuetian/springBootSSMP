package com.mytest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mytest.Mapper.BookMapper;
import com.mytest.pojo.Book;
import com.mytest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id)>0;
    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.updateById(book)>0;
    }

    @Override
    public Book selectById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> getPage(Integer curretnpage, Integer pageSize) {
        IPage page = new Page();
        page.setCurrent(curretnpage);
        page.setSize(pageSize);
        return bookMapper.selectPage(page,null);
    }
}

