package com.zi.service;

import com.github.pagehelper.PageInfo;
import com.zi.dal.sysMenu.entity.SysMenu;
import com.zi.dal.sysMenu.entity.SysMenuExample;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
public interface MenuService {
    SysMenu save(SysMenu param);

    SysMenu update(SysMenu param);

    PageInfo<SysMenu> findByPage(SysMenuExample example, PageInfo page);
}
