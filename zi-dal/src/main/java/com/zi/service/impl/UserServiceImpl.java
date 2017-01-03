package com.zi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.zi.dal.sysUser.entity.SysUser;
import com.zi.dal.sysUser.entity.SysUserExample;
import com.zi.service.UserService;
import com.zi.sys.factory.MapperFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
@Service
public class UserServiceImpl extends MapperFactory implements UserService {

    /**
     * 只取第一个值
     *
     * @param example
     * @return
     */
    public SysUser findByUsername(SysUserExample example) {
        List<SysUser> lists = this.getSysUserMapper().selectByExample(example);
        SysUser result = null;
        if (lists != null && lists.size() > 0) {
            result = lists.get(0);
        }
        return result;
    }

    public PageInfo<SysUser> queryPage(JsonObject param) {
        SysUserExample example = new SysUserExample();
        PageHelper.startPage(1, 2);
        List<SysUser> users = this.getSysUserMapper().selectByExample(example);
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(users);
        return pageInfo;
    }

    public void insert(SysUser user) {
        this.getSysUserMapper().insert(user);
    }
}
