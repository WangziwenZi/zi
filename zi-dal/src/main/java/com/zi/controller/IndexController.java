package com.zi.controller;

import com.zi.sys.factory.ServiceImplFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/8/27.
 */
@Controller
@RequestMapping("/zi/base/index")
public class IndexController extends ServiceImplFactory {

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
