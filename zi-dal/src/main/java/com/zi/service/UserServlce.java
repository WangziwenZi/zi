package com.zi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.zi.dal.user.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public interface UserServlce {
    public PageInfo<User> queryPage(JsonObject param);
}
