package com.zi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zi.dal.user.dao.UserMapper;
import com.zi.dal.user.entity.User;
import com.zi.dal.user.entity.UserExample;
import com.zi.service.UserServlce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
@Service
public class UserServiceImpl implements UserServlce {

    @Autowired
    private UserMapper userMapper;

    public PageInfo<User> createTable() {
        UserExample example = new UserExample();
        PageHelper.startPage(1, 2);
        List<User> users = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    public static void main(String[] args) {

    }
}
