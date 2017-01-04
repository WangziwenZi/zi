package com.zi.sys.advice;

import com.zi.sys.common.BaseController;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.exception.InvalidPassWordException;
import com.zi.sys.exception.UserNotLoginException;
import com.zi.sys.result.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/8/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public void handleIllegalArgumentException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        result.setErrMsg(ex.getMessage());
        result.setSuccess(false);
        super.write(response, result);
    }

    @ExceptionHandler(value = UserNotLoginException.class)
    public void handlerUserNotLoginException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        //用户未登陆
        //判断请求头,是否ajax请求
        String header = request.getHeader("X-Requested-With");
        try {
            if (StringUtils.isNotBlank(header) || StringUtils.equalsIgnoreCase(header, "XMLHttpRequest")) {
                //ajax
                response.setStatus(StateCodeConstant.STATE_401.getCode());
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                Result r = new Result();
                r.setSuccess(false);
                r.setErrMsg(StateCodeConstant.STATE_401.toString());
                this.write(response, r);
            } else {
                response.sendRedirect("/login.htm");
            }
        } catch (Exception e) {

        }
    }

    /**
     * 登录异常拦截
     */
    @ExceptionHandler(value = InvalidPassWordException.class)
    public void InvalidPassWordException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        result.setErrMsg(ex.getMessage());
        result.setSuccess(false);
        super.write(response, result);
    }
}
