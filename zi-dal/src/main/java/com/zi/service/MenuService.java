package com.zi.service;

import com.google.gson.JsonObject;
import com.zi.dal.menu.entity.Menu;
import com.zi.dal.menu.entity.MenuExample;

import java.util.List;

/**
 * Created by Administrator on 2016/8/28.
 */
public interface MenuService {
    public void insert(JsonObject menu);

    public List<Menu> query(MenuExample example);
}
