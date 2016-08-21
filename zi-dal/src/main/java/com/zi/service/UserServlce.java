package com.zi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.zi.dal.user.entity.User;
import com.zi.dal.user.entity.UserExample;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public interface UserServlce {
    public PageInfo<User> queryPage(JsonObject param);

    /**
     * 只取第一个值
     *
     * @param example
     * @return
     */
    public User queryOne(UserExample example);

    public void insert(User user);
}
