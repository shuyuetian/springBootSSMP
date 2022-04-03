package com.mytest.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectExceptionAdvice {
    //异常处理器
    @ExceptionHandler
    public Result doException(Exception ex){
        ex.printStackTrace();
        return new Result(false,null,"服务器异常");
    }
}
