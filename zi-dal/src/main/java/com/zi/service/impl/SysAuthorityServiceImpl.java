package com.zi.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.zi.dal.sysUser.entity.SysUser;
import com.zi.dal.sysauthority.dao.SysAuthorityMapper;
import com.zi.dal.sysauthority.entity.SysAuthority;
import com.zi.dal.sysauthority.entity.SysAuthorityExample;
import com.zi.dal.sysrole.entity.SysRole;
import com.zi.dal.sysrole.entity.SysRoleExample;
import com.zi.dal.sysroleauthority.entity.SysRoleAuthority;
import com.zi.dal.sysroleauthority.entity.SysRoleAuthorityExample;
import com.zi.dal.sysroleuser.entity.SysRoleUser;
import com.zi.dal.sysroleuser.entity.SysRoleUserExample;
import com.zi.service.SysAuthorityService;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.factory.MapperFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30 0030.
 */
@Service
public class SysAuthorityServiceImpl extends MapperFactory implements SysAuthorityService {
    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    /**
     * 查询所有权限
     *
     * @return
     */
    public List<SysAuthority> findByAll() {
        List<SysAuthority> result = sysAuthorityMapper.selectByExample(new SysAuthorityExample());
        return result;
    }

    /**
     * 根据用户id查询
     * @param userId
     * @param state
     * @return
     */
    public List<SysAuthority> findByUserId(String userId, String state) {
//        返回结果
        List<SysAuthority> result = Lists.newArrayList();
        Preconditions.checkArgument(StringUtils.isNotBlank(userId), StateCodeConstant.STATE_412);
        SysUser sysUser = super.getSysUserMapper().selectByPrimaryKey(userId);
        if (sysUser != null) {
            SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
            sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getId());
            List<SysRoleUser> sysRoleUsers = super.getSysRoleUserMapper().selectByExample(sysRoleUserExample);
            List<String> roleUserIds = Lists.newArrayList();
            for (SysRoleUser each : sysRoleUsers) {
                roleUserIds.add(each.getRoleId());
            }

            SysRoleExample sysRoleExample = new SysRoleExample();
            sysRoleExample.createCriteria().andIdIn(roleUserIds);
            sysRoleExample.createCriteria().andIsEnableEqualTo(state);
            List<SysRole> sysRoles = super.getSysRoleMapper().selectByExample(sysRoleExample);
            List<String> roleIds = Lists.newArrayList();
            for (SysRole each : sysRoles) {
                roleIds.add(each.getId());
            }

            SysRoleAuthorityExample sysRoleAuthorityExample = new SysRoleAuthorityExample();
            sysRoleAuthorityExample.createCriteria().andRoleIdIn(roleIds);
            List<SysRoleAuthority> sysRoleAuthorities = super.getSysRoleAuthorityMapper().selectByExample(sysRoleAuthorityExample);
            List<String> roleAuthorityIds = Lists.newArrayList();
            for (SysRoleAuthority each : sysRoleAuthorities) {
                roleAuthorityIds.add(each.getAuthorityId());
            }

            SysAuthorityExample sysAuthorityExample = new SysAuthorityExample();
            sysAuthorityExample.createCriteria().andIdIn(roleAuthorityIds);
            sysAuthorityExample.createCriteria().andIsEnableEqualTo(state);
            result = super.getSysAuthorityMapper().selectByExample(sysAuthorityExample);
        }
        return result;
    }
}
