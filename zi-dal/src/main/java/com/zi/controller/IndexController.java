package com.zi.controller;

import com.zi.sys.factory.ServiceImplFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/8/27.
 */
@Controller
@RequestMapping("/")
public class IndexController extends ServiceImplFactory {

    /**
     * 登录跳转
     *
     * @return
     */
    @RequestMapping("login")
    public String login() {
        return "login";
    }

    /**
     * 未授权页面跳转
     *
     * @return
     */
    @RequestMapping("unauthor")
    public String unauthor() {
        return "unauthor";
    }

    /**
     * 主页面跳转
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
