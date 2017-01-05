package com.zi.sys.factory;

import com.zi.dal.sysMenu.dao.SysMenuMapper;
import com.zi.dal.sysUser.dao.SysUserMapper;
import com.zi.dal.sysauthority.dao.SysAuthorityMapper;
import com.zi.dal.sysrole.dao.SysRoleMapper;
import com.zi.dal.sysroleauthority.dao.SysRoleAuthorityMapper;
import com.zi.dal.sysroleuser.dao.SysRoleUserMapper;
import com.zi.dal.sysroleuser.entity.SysRoleUser;
import com.zi.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Mapper的工厂类 2016/8/21.
 */
public class MapperFactory {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleAuthorityMapper sysRoleAuthorityMapper;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    public SysAuthorityMapper getSysAuthorityMapper() {
        return sysAuthorityMapper;
    }

    public SysRoleUserMapper getSysRoleUserMapper() {
        return sysRoleUserMapper;
    }

    public SysRoleMapper getSysRoleMapper() {
        return sysRoleMapper;
    }

    public SysRoleAuthorityMapper getSysRoleAuthorityMapper() {
        return sysRoleAuthorityMapper;
    }

    public SysMenuMapper getSysMenuMapper() {
        return sysMenuMapper;
    }

    public SysUserMapper getSysUserMapper() {
        return sysUserMapper;
    }
}
