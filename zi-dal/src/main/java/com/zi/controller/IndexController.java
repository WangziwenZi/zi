package com.zi.controller;

import com.zi.sys.factory.ServiceImplFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/8/27.
 */
@Controller
@RequestMapping("/")
public class IndexController extends ServiceImplFactory {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 动态页面跳转接口
     *
     * @param url
     * @return
     */
    @RequestMapping("{url}")
    public String dynamicUrl(@PathVariable String url) {
        logger.info("页面跳转：{}", url);
        return url;
    }
}
