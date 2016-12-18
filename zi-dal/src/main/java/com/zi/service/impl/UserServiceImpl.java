package com.zi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.zi.dal.user.entity.User;
import com.zi.dal.user.entity.UserExample;
import com.zi.service.UserService;
import com.zi.sys.factory.MapperFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
@Service
public class UserServiceImpl extends MapperFactory implements UserService {

    /**
     * 只取第一个值
     *
     * @param example
     * @return
     */
    public User findByUsername(UserExample example) {
        List<User> lists = this.getUserMapper().selectByExample(example);
        User result = null;
        if (lists != null && lists.size() > 0) {
            result = lists.get(0);
        }
        return result;
    }

    public PageInfo<User> queryPage(JsonObject param) {
        UserExample example = new UserExample();
        PageHelper.startPage(1, 2);
        List<User> users = this.getUserMapper().selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    public void insert(User user) {
        this.getUserMapper().insert(user);
    }
}
