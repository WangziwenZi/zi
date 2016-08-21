package com.zi.sys.advice;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.zi.sys.common.BaseController;
import com.zi.sys.result.Result;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/8/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController{

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public void handleIllegalArgumentException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        result.setCode(Integer.parseInt(ex.getMessage()));
        result.setSuccess(false);
        this.write(response,result);
    }
}
