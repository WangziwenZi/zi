package com.zi.realm;

import com.zi.dal.user.entity.User;
import com.zi.dal.user.entity.UserExample;
import com.zi.service.UserService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/16.
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
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(token.getUsername());
        User user = userService.findByUsername(example);
        System.out.println("验证当前登录用户："+ ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        SimpleAuthenticationInfo authentication = new SimpleAuthenticationInfo(user.getEmail(),user.getPassword().toCharArray(),getName());
        return authentication;
    }


}
