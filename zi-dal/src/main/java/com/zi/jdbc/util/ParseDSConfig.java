package com.zi.jdbc.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import javax.xml.transform.sax.SAXResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.annotation.Documented;
import java.sql.Connection;
import java.util.*;

/**
 * 配置文件操作类
 * Created by 汪梓文 on 2016/8/12.
 */
public class ParseDSConfig {

    public ParseDSConfig() {

    }

    //    读取配置文件
    public Vector readConfigInfo(String path) {
        Vector vector = new Vector();
        try {

            Configuration config = new PropertiesConfiguration(String.valueOf(Thread.currentThread().getContextClassLoader().getResource(path)).substring(6));
            DSConfigBean dsb = new DSConfigBean();
            dsb.setDriver(config.getString("jdbc.driverClass"));
            dsb.setUrl(config.getString("jdbc.url"));
            dsb.setUsername(config.getString("jdbc.username"));
            dsb.setPassword(config.getString("jdbc.password"));
            dsb.setName(config.getString("jdbc.database"));
            dsb.setMaxconn(NumberUtils.toInt(config.getString("jdbc.maxConn")));
            vector.add(dsb);

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        return vector;
    }

    public static Connection dbconnection() {
        DBConnectionPoolManager dbpoolManager = DBConnectionPoolManager.getInstance();
        //        创建连接池
//        获取连接
        Connection conn = dbpoolManager.getConnection("leyeoa");
        System.out.println(conn);
        return conn;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new Thread() {
                @Override
                public void run() {
                    DBConnectionPoolManager.getInstance().freeConnection("leyeoa", dbconnection());
                }
            }.start();
        }
//        DBConnectionPoolManager.getInstance().release();
    }
}
