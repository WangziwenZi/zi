package com.zi.sys.advice;

import com.zi.sys.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/8/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public Result handlerException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Result result = new Result();
        result.setSuccess(false);
        result.setErrMsg("错误");
        return result;
    }
}
