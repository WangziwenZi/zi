package com.zi.realm;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Administrator on 2016/11/16.
 */
public class MyRealm extends AuthorizingRealm{
    private static Logger logger = Logger.getLogger(MyRealm.class);
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入doGetAuthorizationInfo方法.");
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入doGetAuthenticationInfo方法.");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("验证当前登录用户："+ ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        return null;
    }


}
