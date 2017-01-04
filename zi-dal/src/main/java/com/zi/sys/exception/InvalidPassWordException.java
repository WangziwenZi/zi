package com.zi.sys.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 用于捕获登录异常 on 2017/1/4 0004.
 */
public class InvalidPassWordException extends AuthenticationException {
    public InvalidPassWordException() {

    }

    public InvalidPassWordException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidPassWordException(Throwable cause) {
        super(cause);
    }

    public InvalidPassWordException(String msg) {
        super(msg);
    }
}
