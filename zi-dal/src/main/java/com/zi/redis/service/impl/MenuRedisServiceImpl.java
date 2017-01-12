package com.zi.redis.service.impl;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zi.dal.sysmenu.entity.SysMenu;
import com.zi.redis.service.MenuRedisService;
import com.zi.sys.constant.SysConstant;
import com.zi.sys.factory.MapperFactory;
import com.zi.sys.util.LoginSysUserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;

@Service
public class MenuRedisServiceImpl extends MapperFactory implements MenuRedisService {
    private static final Logger logger = LoggerFactory.getLogger(MenuRedisServiceImpl.class);

    /**
     * 读取缓存信息
     *
     * @return
     */
    public List<SysMenu> findByMenu() {
        Object result = getRedisTemplate().execute(new RedisCallback<List<SysMenu>>() {
            public List<SysMenu> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                List<SysMenu> result = Lists.newArrayList();
                byte[] key = getRedisTemplate().getStringSerializer().serialize(LoginSysUserUtil.findSysUser().getId());
                long start = 0;
                long end = redisConnection.lLen(key);
                List<byte[]> data = redisConnection.lRange(key, 0, end);
                if (data != null) {
                    RedisSerializer<String> serializer = getRedisTemplate().getStringSerializer();
                    for (byte[] each : data) {
                        String value = serializer.deserialize(each);
                        JsonObject jsonObject = new JsonParser().parse(value).getAsJsonObject();
                        result.add(new Gson().fromJson(jsonObject, SysMenu.class));
                    }
                }
                return result;
            }
        });
        return (List<SysMenu>) result;
    }

    /**
     * 保存菜单
     *
     * @param menus
     * @return
     */
    public boolean saveByUserId(final List<SysMenu> menus) {
        getRedisTemplate().execute(new RedisCallback() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] key = getRedisTemplate().getStringSerializer().serialize(LoginSysUserUtil.findSysUser().getId());
                List<byte[]> data = Lists.newArrayList();
                for (SysMenu each : menus) {
                    JsonObject jsonSysMenu = new Gson().toJsonTree(each).getAsJsonObject();
                    String string = jsonSysMenu.toString();
                    redisConnection.lPush(key, getRedisTemplate().getStringSerializer().serialize(string));
                }
                return null;
            }
        });
        return true;
    }
}
