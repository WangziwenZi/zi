package com.zi.controller;

import com.mysql.jdbc.Security;
import com.zi.dal.piresource.entity.PiResource;
import com.zi.sys.factory.ServiceImplFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
        Subject subject = SecurityUtils.getSubject();
        PiResource pi = new PiResource();
        pi.setValue("/zi/base/index/**");
        pi.setPermission("admin");
//        this.getPiResourceService().saveResource(pi);
        return "index";
    }
}
