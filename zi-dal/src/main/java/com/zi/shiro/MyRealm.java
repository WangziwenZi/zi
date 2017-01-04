package com.zi.shiro;

import com.zi.dal.sysUser.entity.SysUser;
import com.zi.dal.sysUser.entity.SysUserExample;
import com.zi.service.UserService;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.exception.InvalidPassWordException;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 汪梓文 版权所有 © Copyright 2017<br/>
 * 说明:鉴权使用 <br/>
 * 创建日期: 2016年7月13日 上午9:37:09 <br/>
 * 作者: wzw
 */
@Service
public class MyRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(MyRealm.class);
    @Autowired
    private UserService userService;

    /**
     * 角色判断
     *
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("进入doGetAuthorizationInfo方法.");
        return null;
    }

    /**
     * 用户判断
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("进入doGetAuthenticationInfo方法.");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUserExample example = new SysUserExample();
        example.createCriteria().andEmailEqualTo(token.getUsername());
        SysUser user = userService.findByUsername(example);
//        查询用户是否存在
        if (user == null)
            throw new InvalidPassWordException(StateCodeConstant.STATE_401.toString());
//        比对密码是否相等
        if (!StringUtils.equals(String.valueOf(token.getPassword()), user.getPassword()))
            throw new InvalidPassWordException(StateCodeConstant.STATE_401.toString());
        logger.info("验证当前登录用户：" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        return new SimpleAuthenticationInfo(user.getEmail(), user.getPassword().toCharArray(), getName());
    }


}
