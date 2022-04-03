package com.mytest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mytest.Mapper.BookMapper;
import com.mytest.pojo.Book;
import com.mytest.service.IBookService;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookMapper,Book> implements IBookService {
}
