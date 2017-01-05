package com.zi.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.zi.dal.sysUser.entity.SysUser;
import com.zi.dal.sysrole.entity.SysRole;
import com.zi.dal.sysrole.entity.SysRoleExample;
import com.zi.dal.sysroleuser.entity.SysRoleUser;
import com.zi.dal.sysroleuser.entity.SysRoleUserExample;
import com.zi.service.SysRoleService;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.factory.MapperFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
@Service
public class SysRoleServiceImpl extends MapperFactory implements SysRoleService {
    /**
     *  根据用户id查询用户的角色
     * @param id 用户id
     * @param enable 查询状态
     * @return  没有结果返回一个list对象
     */
    public List<SysRole> findByUserId(String id, String enable) {
//        返回值
        List<SysRole> result = Lists.newArrayList();
        Preconditions.checkArgument(StringUtils.isNotBlank(id), StateCodeConstant.STATE_412);
        SysUser sysUser = super.getSysUserMapper().selectByPrimaryKey(id);
        if (sysUser != null) {
            SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
            sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getId());
            List<SysRoleUser> sysRoleUsers = super.getSysRoleUserMapper().selectByExample(sysRoleUserExample);
            if (sysRoleUsers != null) {
                List<String> roleIds = Lists.newArrayList();
                for (SysRoleUser each : sysRoleUsers) {
                    roleIds.add(each.getRoleId());
                }
//                查询角色详情
                SysRoleExample sysRoleExample = new SysRoleExample();
                sysRoleExample.createCriteria().andIdIn(roleIds);
                sysRoleExample.createCriteria().andIsEnableEqualTo(enable);
                result = super.getSysRoleMapper().selectByExample(sysRoleExample);
            }
        }
        return result;
    }
}
