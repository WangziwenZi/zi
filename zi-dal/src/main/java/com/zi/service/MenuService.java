package com.zi.service;

import com.github.pagehelper.PageInfo;
import com.zi.dal.sysmenu.entity.SysMenu;
import com.zi.dal.sysmenu.entity.SysMenuExample;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
public interface MenuService {
    SysMenu save(SysMenu param);

    SysMenu update(SysMenu param);

    PageInfo<SysMenu> findByPage(SysMenuExample example, PageInfo page);

    /**
     * 根据当前用户id查询菜单信息
     *
     * @return
     */
    public List<SysMenu> findByUserId();

}
