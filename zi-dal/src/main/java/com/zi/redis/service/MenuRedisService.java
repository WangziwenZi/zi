package com.zi.redis.service;

import com.zi.dal.sysmenu.entity.SysMenu;

import java.util.List;

/**
 * Created by haoyuankeji on 2017/1/12.
 */
public interface MenuRedisService {
    /**
     * 读取缓存信息
     *
     * @return
     */
    public List<SysMenu> findByMenu();

    /**
     * 保存菜单
     *
     * @param menus
     * @return
     */
    public boolean saveByUserId(final List<SysMenu> menus);
}
