package com.zi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zi.dal.sysUser.entity.SysUser;
import com.zi.dal.sysauthority.entity.SysAuthority;
import com.zi.dal.sysauthority.entity.SysAuthorityExample;
import com.zi.dal.sysmenu.entity.SysMenu;
import com.zi.dal.sysmenu.entity.SysMenuExample;
import com.zi.dal.sysrole.entity.SysRole;
import com.zi.dal.sysrole.entity.SysRoleExample;
import com.zi.dal.sysrolemenu.entity.SysRoleMenu;
import com.zi.dal.sysrolemenu.entity.SysRoleMenuExample;
import com.zi.dal.sysroleuser.entity.SysRoleUser;
import com.zi.dal.sysroleuser.entity.SysRoleUserExample;
import com.zi.service.MenuService;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.constant.SysConstant;
import com.zi.sys.factory.MapperFactory;
import com.zi.sys.util.LoginSysUserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
@Service
public class MenuServiceImpl extends MapperFactory implements MenuService {

    /**
     * 保存
     *
     * @param param
     * @return
     */
    public SysMenu save(SysMenu param) {
        // 不为空拒绝保存
        Preconditions.checkArgument(StringUtils.isBlank(param.getId()), StateCodeConstant.STATE_412);
        super.getSysMenuMapper().insert(param);
        return null;
    }

    /**
     * 修改
     *
     * @param param
     * @return
     */
    public SysMenu update(SysMenu param) {
//        为空拒绝修改
        Preconditions.checkArgument(StringUtils.isNotBlank(param.getId()), StateCodeConstant.STATE_412);
        super.getSysMenuMapper().updateByPrimaryKeySelective(param);
        return null;
    }

    /**
     * 分页查询
     *
     * @param example
     * @param page
     * @return
     */
    public PageInfo<SysMenu> findByPage(SysMenuExample example, PageInfo page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysMenu> data = super.getSysMenuMapper().selectByExample(example);
        return new PageInfo<SysMenu>(data);
    }

    /**
     * 根据当前用户id查询菜单信息
     *
     * @return
     */
    public List<SysMenu> findByUserId() {
        List<SysMenu> result = Lists.newArrayList();
        SysUser sysUser = LoginSysUserUtil.findSysUser();
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getId());
        List<SysRoleUser> sysRoleUsers = super.getSysRoleUserMapper().selectByExample(sysRoleUserExample);
        if (sysRoleUsers != null) {
            List<String> sysRoleIds = Lists.newArrayList();
            for (SysRoleUser each : sysRoleUsers) {
                sysRoleIds.add(each.getRoleId());
            }
            SysRoleExample sysRoleExample = new SysRoleExample();
            sysRoleExample.createCriteria().andIdIn(sysRoleIds);
            sysRoleExample.createCriteria().andIsEnableEqualTo(SysConstant.NO.getValue());
            List<SysRole> sysRoles = super.getSysRoleMapper().selectByExample(sysRoleExample);
            sysRoleIds.clear();
            for (SysRole each : sysRoles) {
                sysRoleIds.add(each.getId());
            }

            SysRoleMenuExample sysRoleMenuExample = new SysRoleMenuExample();
            sysRoleMenuExample.createCriteria().andRoleIdIn(sysRoleIds);
            List<SysRoleMenu> sysRoleMenus = super.getSysRoleMenuMapper().selectByExample(sysRoleMenuExample);
            List<String> sysMenuIds = Lists.newArrayList();
            for (SysRoleMenu each : sysRoleMenus) {
                sysMenuIds.add(each.getMenuId());
            }

            SysMenuExample sysMenuExample = new SysMenuExample();
            sysMenuExample.createCriteria().andIdIn(sysMenuIds);
            sysMenuExample.createCriteria().andIsEnableEqualTo(SysConstant.NO.getValue());
            result = super.getSysMenuMapper().selectByExample(sysMenuExample);
            List<String> sysAuthorityIds = Lists.newArrayList();
            for (SysMenu each : result) {
                sysAuthorityIds.add(each.getAuthorityId());
            }

            SysAuthorityExample sysAuthorityExample = new SysAuthorityExample();
            sysAuthorityExample.createCriteria().andIdIn(sysAuthorityIds);
            List<SysAuthority> sysAuthorities = super.getSysAuthorityMapper().selectByExample(sysAuthorityExample);
            for (SysMenu each : result) {
                for (SysAuthority sysAuthority : sysAuthorities) {
                    if (StringUtils.equals(sysAuthority.getId(), each.getAuthorityId())) {
                        each.setSysAuthority(sysAuthority);
                    }
                }
            }
        }
        return result;
    }

    public JsonArray toJson(List<SysMenu> sysMenus) {
        JsonArray result = new JsonArray();
        for (SysMenu each : sysMenus) {
            if (StringUtils.isBlank(each.getParentId())) {
                result.add(new Gson().toJsonTree(each));
            }
        }
        for (JsonElement each : result) {
            JsonObject eachMenu = each.getAsJsonObject();
            eachMenu.add("childs", recursive(eachMenu, sysMenus));
        }
        return result;
    }

    private JsonArray recursive(JsonObject node, List<SysMenu> sysMenus) {
        JsonArray result = new JsonArray();
        for (SysMenu each : sysMenus) {
            if (StringUtils.equals(node.get("id").getAsString(), each.getParentId())) {
                JsonObject jsonEach = new Gson().toJsonTree(each).getAsJsonObject();
//                递归查找当前节点的子节点
                jsonEach.add("childs", recursive(jsonEach, sysMenus));
                result.add(jsonEach);
            }
        }
        return result;
    }

}
