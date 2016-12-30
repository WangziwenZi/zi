package com.zi.service;

import com.zi.dal.sysauthority.entity.SysAuthority;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30 0030.
 */
public interface SysAuthorityService {
    /**
     * 查询所有权限
     *
     * @return
     */
    public List<SysAuthority> findByAll();
}
