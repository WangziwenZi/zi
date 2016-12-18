package com.zi.sys.common;

import com.zi.dal.piresource.entity.PiResource;
import com.zi.service.PiResourceService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.lf5.util.Resource;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

    private String filterChainDefinitions;

    @Autowired
    private PiResourceService piResourceService;
    /**
     * 默认premission字符串
     */
    public static final String PREMISSION_STRING = "perms[\"{0}\"]";

    /**
     * 获取权限信息
     * @return
     * @throws Exception
     *
     */
    public Ini.Section getObject() throws Exception {
        List<PiResource> resource = piResourceService.findByAll();
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        for (PiResource each : resource) {
            if (StringUtils.isNotBlank(each.getValue()) && StringUtils.isNotBlank(each.getPermission())) {
                section.put(each.getValue(), MessageFormat.format(PREMISSION_STRING, each.getPermission()));
            }
        }
        return section;
    }

    /**
     * 通过filterChainDefinitions对默认的url过滤定义
     *
     * @param filterChainDefinitions 默认的url过滤定义
     */
    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public Class<?> getObjectType() {
        return this.getClass();
    }

    public boolean isSingleton() {
        return false;
    }
}
