package com.zi.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.zi.dal.sysmenu.entity.SysMenu;
import com.zi.dal.sysmenu.entity.SysMenuExample;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.constant.SysConstant;
import com.zi.sys.factory.ServiceImplFactory;
import com.zi.sys.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends ServiceImplFactory {

    /**
     * 保存 OR 修改
     *
     * @param param id不为空表示修改
     * @return
     */
    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Result saveOrUpdate(SysMenu param) {
        Preconditions.checkArgument(StringUtils.isNotBlank(param.getIco()), StateCodeConstant.STATE_412);
        Preconditions.checkArgument(StringUtils.isNotBlank(param.getAuthorityId()), StateCodeConstant.STATE_412);
        Preconditions.checkArgument(StringUtils.isNotBlank(param.getTitle()), StateCodeConstant.STATE_412);
        if (StringUtils.isNotBlank(param.getId())) {
            super.getMenuService().update(param);
        } else {
            super.getMenuService().save(param);
        }
        return new Result();
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping("findByPage")
    @ResponseBody
    public Result findByPage(PageInfo<SysMenu> param) {
        PageInfo<SysMenu> result = super.getMenuService().findByPage(new SysMenuExample(), param);
        return new Result();
    }

    /**
     * 查询用户菜单
     *
     * @return
     */
    @RequestMapping("findByUserId")
    @ResponseBody
    public Result findByUserId() {
        List<SysMenu> data = super.getMenuService().findByUserId();
        JsonArray result = super.getMenuService().toJson(data);
        return new Result(SysConstant.TRUE.isBooValue(), result);
    }
}
