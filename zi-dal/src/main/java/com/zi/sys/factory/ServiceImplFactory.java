package com.zi.sys.factory;

import com.zi.service.UserService;
import com.zi.sys.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/8/21.
 */
public class ServiceImplFactory extends BaseController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
}
