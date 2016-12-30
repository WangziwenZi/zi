package com.zi.sys.factory;

import com.zi.dal.menu.dao.MenuMapper;
import com.zi.dal.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/8/21.
 */
public class MapperFactory {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;


    public MenuMapper getMenuMapper() {
        return menuMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }
}
