package com.zi.shiro;

import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * 汪梓文 版权所有 © Copyright 2017<br/>
 * 说明: 防止二次登陆的功能<br/>
 * 创建日期: 2017年1月3日 15:57:17 <br/>
 * 作者: wzw
 */
public class KickoutSessionControlFilter extends AccessControlFilter {
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
