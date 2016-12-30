package com.zi.shiro;

import com.zi.dal.user.entity.User;
import com.zi.sys.common.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 说明：session超时过滤
 * 项目名称：zi
 * 创建时间：二〇一六年十二月三十日 15:05:18
 * 作者：汪梓文
 */
public class SessionFilter extends BaseController implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        //只过滤了ajax请求时session超时
        // 如果是ajax请求响应头会有，x-requested-with
        if (httpServletRequest.getHeader("x-requested-with") != null
                && httpServletRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            Subject subject = SecurityUtils.getSubject();
            if (subject.getPrincipals() == null || subject.getPrincipals().getPrimaryPrincipal() == null) {
                write(httpServletResponse, "登录超时，请重新登录");
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
