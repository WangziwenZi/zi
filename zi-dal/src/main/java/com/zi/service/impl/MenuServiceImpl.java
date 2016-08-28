package com.zi.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zi.dal.menu.entity.Menu;
import com.zi.dal.menu.entity.MenuExample;
import com.zi.service.MenuService;
import com.zi.sys.factory.MapperFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/28.
 */
@Service
public class MenuServiceImpl extends MapperFactory implements MenuService {

    public void insert(JsonObject param) {
        Menu menu = new Gson().fromJson(param, Menu.class);
        this.getMenuMapper().insert(menu);
    }

    public List<Menu> query(MenuExample example) {
        List<Menu> result = this.getMenuMapper().selectByExample(example);
        return result;
    }

}
