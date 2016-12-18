package com.zi.sys.common;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Administrator on 2016/12/17.
 */
public class RolesAuthorizationFilter extends AuthorizationFilter {

//    符合一个角色条件即可
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }
}
