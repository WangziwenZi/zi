package com.zi.controller;

import com.zi.sys.factory.ServiceImplFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/8/27.
 */
@Controller
@RequestMapping("/")
public class IndexController extends ServiceImplFactory {
    @RequestMapping("{url}")
    public String dynamicUrl(@PathVariable String url){
        System.out.print("进入动态URL方法");
        return url;
    }
}
