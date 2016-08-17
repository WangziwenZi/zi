package com.zi.controller;

import com.google.common.base.Preconditions;
import com.zi.dal.user.entity.User;
import com.zi.service.UserServlce;
import com.zi.sys.result.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/8/16.
 */
@RestController
@RequestMapping("/zi/base/user/")
public class UserController {

    @Autowired
    private UserServlce userServlce;

    @RequestMapping("login")
    @ResponseBody
    public Result login(User user) {
        if (StringUtils.isBlank(user.getName())){
            throw new IllegalArgumentException("123");
        }
        return null;
    }

}
