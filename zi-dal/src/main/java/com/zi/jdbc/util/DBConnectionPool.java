package com.zi.jdbc.util;

/**
 * 数据库连接池类
 * Created by 汪梓文 on 2016/8/12.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 连接池类是对某一数据库所有连接的“缓冲池”，主要实现以下功能：
 * ①从连接池读取或创建可用的连接；
 * ②使用完毕之后，把连接还给连接池；
 * ③在系统关闭之前，断开所有连接并释放连接占用的系统资源；
 * ④还能够处理无效连接（原来登记为可用的连接，由于某种原因不再可用，如超时，通讯问题）
 * 并能通过限制连接池总数不低于某个预定值和不超过某个预定值
 * ⑤当多个数据库时，且数据库是动态增加的话，将会加到配置文件中。
 */
public class DBConnectionPool {
    //    连接
    private Connection conn = null;
    //    连接数
    private int inUsed = 0;
    //    容器，空闲连接
    private ArrayList freeConnections = new ArrayList();
    //    最小连接数
    private int minConn;
    //    最大连接数
    private int maxConn;
    //    连接池名字
    private String name;
    //    密码
    private String password;
    //    数据库连接地址
    private String url;
    //    驱动
    private String driver;
    //    用户名
    private String user;
    //    定时
    private Timer timer;

    private int count = 0;

    public DBConnectionPool() {

    }

    /**
     * 创建连接池
     *
     * @param name
     * @param driver
     * @param URL
     * @param user
     * @param password
     * @param maxConn
     */
    public DBConnectionPool(String name, String driver, String URL, String user, String password, int maxConn) {
        this.name = name;
        this.driver = driver;
        this.url = URL;
        this.user = user;
        this.password = password;
        this.maxConn = maxConn;
    }

    /**
     * 用完，释放连接池
     *
     * @param conn
     */
    public synchronized void freeConnection(Connection conn) {
        this.freeConnections.add(conn); //添加到空闲池末尾
        this.inUsed--;
        System.out.println("关闭线程" + this.freeConnections.size());
    }

    /**
     * timeout, 根据timeout获得连接
     * 问题：连接递归时
     */
    public synchronized Connection getConnection(long timeout) {
        Connection conn = null;
        if (this.freeConnections.size() > 0) {
            conn = (Connection) this.freeConnections.get(0);
            if (conn == null) conn = getConnection(timeout);
        } else {
//            创建新连接
            conn = newConnection();
        }

        if (this.maxConn == 0 || this.maxConn < this.inUsed) {
            conn = null;    //超过最大连接数，暂时不能获取连接
        }
        if (conn != null) {
            this.inUsed++;
        }
        return conn;
    }

    /**
     * 从连接池里得到连接
     *
     * @return
     */
    public synchronized Connection getConnection() {
        Connection conn = null;

        if (isMaxConn()) {
            if (this.freeConnections.size() > 0) {
                conn = (Connection) this.freeConnections.get(0);
                this.freeConnections.remove(0);    //如果连接分配出去了就从空闲连接里删除
                if (conn == null) conn = getConnection();
            } else {
                conn = newConnection();
            }
        }


        if (conn != null) {
            this.inUsed++;
            String message = "得到%s的连接，现有%s个连接在使用,空闲连接%s";
            System.out.println(String.format(message, this.name, this.inUsed, this.freeConnections.size()));
        }
        return conn;
    }

    /**
     * 判断连接数是否已满
     *
     * @return
     */

    public boolean isMaxConn() {
        if (this.maxConn == 0 || this.maxConn <= this.inUsed) {
            System.out.println("当前连接数为" + this.inUsed + "连接已满");
            return false;
        }
        return true;
    }

    /**
     * 创建新连接
     *
     * @return
     */
    private Connection newConnection() {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败。。。");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接创建失败。。。");
        }
        return conn;

    }

    /**
     * 释放全部连接
     */
    public synchronized void release() {
        Iterator allConn = this.freeConnections.iterator();
        while (allConn.hasNext()) {
            Connection conn = (Connection) allConn.next();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.freeConnections.clear();
    }

    public int getMinConn() {
        return minConn;
    }

    public void setMinConn(int minConn) {
        this.minConn = minConn;
    }

    public int getMaxConn() {
        return maxConn;
    }

    public void setMaxConn(int maxConn) {
        this.maxConn = maxConn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
