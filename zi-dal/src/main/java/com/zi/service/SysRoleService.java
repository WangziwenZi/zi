package com.zi.service;

import com.zi.dal.sysrole.entity.SysRole;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
public interface SysRoleService {
    /**
     *  根据用户id查询用户的角色
     * @param id 用户id
     * @param enable 查询状态
     * @return  没有结果返回一个list对象
     */
    public List<SysRole> findByUserId(String id, String enable);
}
