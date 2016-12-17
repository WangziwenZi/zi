package com.zi.controller;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import com.zi.annotation.JsonAnnotation;
import com.zi.dal.menu.entity.Menu;
import com.zi.dal.menu.entity.MenuExample;
import com.zi.sys.common.BaseController;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.factory.ServiceImplFactory;
import com.zi.sys.result.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/8/28.
 */
@RequestMapping(value = "/zi/base/menu/")
@Controller
public class MenuController extends ServiceImplFactory {

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Result saveOrUpdate(@JsonAnnotation JsonObject menu) {
          Preconditions.checkArgument(StringUtils.isNotBlank(menu.get("title").getAsString()), StateCodeConstant.STATE_404);
        Preconditions.checkArgument(StringUtils.isNotBlank(menu.get("url").getAsString()), StateCodeConstant.STATE_404);

        this.getMenuService().insert(menu);

        Result result = new Result();
        result.setMessage("菜单创建成功");
        return result;
    }

    @RequestMapping("list")
    @ResponseBody
    public Result list() {
        Result result = new Result();
        MenuExample example = new MenuExample();
        result.setData(this.getMenuService().query(example));
        return result;
    }
}
