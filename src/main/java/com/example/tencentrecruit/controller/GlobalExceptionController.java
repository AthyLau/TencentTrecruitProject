package com.example.tencentrecruit.controller;


import com.example.tencentrecruit.CommonBox.Result;
import com.example.tencentrecruit.CommonBox.ResultCode;
import com.example.tencentrecruit.CommonBox.ResultGenerator;
import com.example.tencentrecruit.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * Function: 全局异常处理类  RestControllerAdvice负责及时发送消息
 *
 * @author liubing
 * Date: 2018/9/6 下午4:28
 * @since JDK 1.8
 */
@RestControllerAdvice
public class GlobalExceptionController {


    /**
     * 在controller中，根据controller上的Validated注解，拦截在请求中的参数
     *
     * @param exception 异常信息集合
     * @return 结果集
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handle(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            sb.append(violation.getMessage() + "\n");
        }
        return ResultGenerator.genNeutralResult(4004, sb.toString());
    }


    /**
     * 捕捉UnauthorizedException，自己定义的全局异常
     *
     * @return 结果集
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Result handle401() {
        return ResultGenerator.genNeutralResult(ResultCode.NOT_AUTH, "未授权 [ExceptionController.UnauthorizedException.handle401]");
    }


    /**
     * 请求过来没有传参数，或者参数不够数量
     *
     * @return 返回4000 状态码
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result parameterException() {
        return ResultGenerator.genFailResult("请求的参数不完整！");
    }


    //=========================================全局异常拦截方法如下======================================================

    /**
     * 捕捉其他所有异常
     *
     * @param request 请求信息
     * @param ex      异常类型
     * @return 结果集
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result globalException(HttpServletRequest request, Throwable ex) {
        return ResultGenerator.genNeutralResult(getStatus(request).value(), "暂时不能为您提供服务！具体原因如下：" + ex.getMessage());
    }

    /**
     * 获取java给我们提供的未被拦截的异常状态码
     *
     * @param request
     * @return
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}

