package com.zi.sys.factory;

import com.zi.service.MenuService;
import com.zi.service.UserService;
import com.zi.sys.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/8/21.
 */
public class ServiceImplFactory extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    public MenuService getMenuService() {
        return menuService;
    }

    public UserService getUserService() {
        return userService;
    }
}
