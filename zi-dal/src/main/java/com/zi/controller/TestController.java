package com.zi.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import com.zi.annotation.JsonAnnotation;
import com.zi.dal.user.entity.User;
import com.zi.service.UserServlce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserServlce userServlce;

    @RequestMapping("test")
    @ResponseBody
    public PageInfo<User> test(@JsonAnnotation JsonObject param) {
        Preconditions.checkArgument(param.get("id") != null, "id参数为空");
        PageInfo<User> users = userServlce.createTable();
        return users;
    }
}
