package com.zi.sys.factory;

import com.zi.dal.sysMenu.dao.SysMenuMapper;
import com.zi.dal.sysUser.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Mapper的工厂类 2016/8/21.
 */
public class MapperFactory {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysMenuMapper getSysMenuMapper() {
        return sysMenuMapper;
    }

    public SysUserMapper getSysUserMapper() {
        return sysUserMapper;
    }
}
