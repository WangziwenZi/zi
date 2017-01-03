package com.zi.shiro;

import com.zi.dal.sysUser.entity.SysUser;
import com.zi.dal.sysUser.entity.SysUserExample;
import com.zi.service.UserService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 汪梓文 版权所有 © Copyright 2017<br/>
 * 说明:鉴权使用 <br/>
 * 创建日期: 2016年7月13日 上午9:37:09 <br/>
 * 作者: wzw
 */
@Service
public class MyRealm extends AuthorizingRealm{
    private static Logger logger = Logger.getLogger(MyRealm.class);
    @Autowired
    private UserService userService;

    /**
     * 角色判断
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入doGetAuthorizationInfo方法.");
        return null;
    }

    /**
     * 用户判断
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入doGetAuthenticationInfo方法.");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUserExample example = new SysUserExample();
        example.createCriteria().andEmailEqualTo(token.getUsername());
        SysUser user = userService.findByUsername(example);
        System.out.println("验证当前登录用户："+ ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        SimpleAuthenticationInfo authentication = new SimpleAuthenticationInfo(user.getEmail(),user.getPassword().toCharArray(),getName());
        return authentication;
    }


}
