package com.zi.interceptor;

import com.zi.dal.sysUser.entity.SysUser;
import com.zi.sys.constant.SysConstant;
import com.zi.sys.exception.UserNotLoginException;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/8/27.
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean flag = true;
        SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(SysConstant.THE_LANDING_USER);
        if (user == null) {
            flag = false;
            throw new UserNotLoginException();
        }
        return flag;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
