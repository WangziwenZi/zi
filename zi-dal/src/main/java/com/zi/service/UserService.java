package com.zi.service;

import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.zi.dal.sysUser.entity.SysUser;
import com.zi.dal.sysUser.entity.SysUserExample;

/**
 * Created by Administrator on 2016/8/12.
 */
public interface UserService {
    public PageInfo<SysUser> queryPage(JsonObject param);

    /**
     * 只取第一个值
     *
     * @param example
     * @return
     */
    public SysUser findByUsername(SysUserExample example);

    public void insert(SysUser user);
}
