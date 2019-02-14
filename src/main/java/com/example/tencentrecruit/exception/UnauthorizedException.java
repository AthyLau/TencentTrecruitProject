package com.example.tencentrecruit.exception;


/**
 * Function: 就是一个异常定义类，定义自己的异常处理标准
 *
 * @author miluo
 * Date: 2018/9/6 下午4:28
 * @since JDK 1.8
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
