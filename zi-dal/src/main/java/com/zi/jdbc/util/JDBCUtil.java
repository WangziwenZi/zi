package com.zi.jdbc.util;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Date;


/**
 * Created by Administrator on 2016/8/12.
 */
public class JDBCUtil {
    private static Logger log = org.apache.log4j.Logger.getLogger(JDBCUtil.class);
    private static String URL = "jdbc:mysql://localhost:3306/leyeoa?characterEncoding=utf8&useSSL=false";
    private static String user = "root";
    private static String password = "admin";

    private static JDBCUtil instance = null;

    private JDBCUtil() {

    }

    public static JDBCUtil getInstance() {
        if (instance == null) {
            synchronized (JDBCUtil.class) {
                try {
                    instance = new JDBCUtil();
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    log.error("jdbc驱动加载失败。" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }

    /**
     * 连接池获取连接
     *
     * @return
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            log.error("获取jdbc连接失败" + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     *
     * @param rst
     * @param st
     * @param conn
     */
    public void release(ResultSet rst, Statement st, Connection conn) {
        if (rst != null) {
            try {
                rst.close();
            } catch (SQLException e) {
                log.error("记录集关闭失败" + e.getMessage());
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                log.error("关闭声明失败" + e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("关闭连接对象失败" + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        long beginTime = new Date().getTime();
        Connection conn = JDBCUtil.getInstance().getConnection();

        long endTime = new Date().getTime();
        System.out.println(endTime-beginTime);
    }
}