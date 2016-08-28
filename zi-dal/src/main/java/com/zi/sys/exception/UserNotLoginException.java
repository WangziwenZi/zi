package com.zi.sys.exception;

/**
 * Created by Administrator on 2016/8/27.
 */
public class UserNotLoginException extends Exception {
    public UserNotLoginException() {
        super();
    }

    public UserNotLoginException(String message) {
        super(message);
    }
}
