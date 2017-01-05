package com.zi.sys.util;

import com.google.common.base.Preconditions;
import com.zi.dal.sysUser.entity.SysUser;
import com.zi.sys.constant.StateCodeConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 获取用户登录信息 on 2017/1/5 0005.
 */
public class LoginSysUserUtil {

    public static SysUser findSysUser() {
        Subject subject = SecurityUtils.getSubject();
        Object obj = subject.getPrincipal();
        Preconditions.checkArgument(obj != null, StateCodeConstant.STATE_403);
        return (SysUser) obj;
    }
}
