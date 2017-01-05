package com.zi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.zi.dal.sysMenu.entity.SysMenu;
import com.zi.dal.sysMenu.entity.SysMenuExample;
import com.zi.service.MenuService;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.factory.MapperFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

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

    public PageInfo<SysMenu> findByPage(SysMenuExample example, PageInfo page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysMenu> data = super.getSysMenuMapper().selectByExample(example);
        return new PageInfo<SysMenu>(data);
    }
}
