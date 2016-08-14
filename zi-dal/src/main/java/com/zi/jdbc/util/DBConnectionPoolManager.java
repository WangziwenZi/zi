package com.zi.jdbc.util;

/**
 * 资源池管理类
 * 连接池的引用主要是为了方便多个连接池的使用和管理，如系统需要连接不同的数据库，或连接相同的数据库但由不同的用户使用不同的账户密码
 * Created by 汪梓文 on 2016/8/12.
 */

import java.sql.Connection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 对多个连接池对象的管理，具有以下功能：
 * ①装载并注册特定数据库的JDBC驱动程序；
 * ②根据属性文件给定的信息，创建连接池对象；
 * ③为方便管理多个连接池，为每一个连接池对象取一个名字，实现连接池名字与其实例之间的映射；
 * ④跟踪客户使用情况，以便需要时关闭连接释放资源。
 */
public class DBConnectionPoolManager {
    private static DBConnectionPoolManager instance; //唯一数据库池管理实例类
    private static int clients; //客户连接数
    private Vector drivers = new Vector();  //驱动信息
    private ConcurrentHashMap pools = new ConcurrentHashMap();    //连接池

    private DBConnectionPoolManager() {
        init();
    }

    /**
     * 得到唯一实例管理类
     *
     * @return
     */
    public static synchronized DBConnectionPoolManager getInstance() {
        if (instance == null) {
            instance = new DBConnectionPoolManager();
        }
        return instance;
    }

    /**
     * 释放连接
     *
     * @param name
     * @param conn
     */
    public void freeConnection(String name, Connection conn) {
        DBConnectionPool pool = (DBConnectionPool) this.pools.get(name);
        if (pool != null) pool.freeConnection(conn);

    }

    /**
     * 根据名称从连接池中获取连接
     *
     * @param name
     * @return
     */
    public Connection getConnection(String name) {
        DBConnectionPool pool = null;
        Connection conn = null;
        pool = (DBConnectionPool) this.pools.get(name);  //根据名字获取连接池
        conn = pool.getConnection();    //从选定连接池中获取连接
        if (conn != null)
            System.out.println("得到连接。。。");
        return conn;
    }

    /**
     * 得到一个连接，根据连接池的名字和等待时间
     *
     * @param name
     * @param timeout
     * @return
     */
    public Connection getConnection(String name, long timeout) {
        DBConnectionPool pool = null;
        Connection conn = null;
        pool = (DBConnectionPool) this.pools.get(name);  //根据名字获取连接池
        conn = pool.getConnection(timeout);    //从选定连接池中获取连接
        if (conn != null)
            System.out.println("得到连接。。。");
        return conn;
    }

    /**
     * 释放所有连接
     */
    public void release() {
        Enumeration allpools = pools.elements();
        while (allpools.hasMoreElements()) {
            DBConnectionPool pool = (DBConnectionPool) allpools.nextElement();
            if (pool != null) pool.release();
        }
        System.out.println("已关闭所有线程。");
        pools.clear();
    }

    /**
     * 创建连接池
     *
     * @param dsb
     */
    private void createPools(DSConfigBean dsb) {
        DBConnectionPool dbpool = new DBConnectionPool();
        dbpool.setDriver(dsb.getDriver());
        dbpool.setMaxConn(dsb.getMaxconn());
        dbpool.setName(dsb.getName());
        dbpool.setUser(dsb.getUsername());
        dbpool.setPassword(dsb.getPassword());
        dbpool.setUrl(dsb.getUrl());
        System.out.println("最大连接数：" + dsb.getMaxconn());
        pools.put(dsb.getName(), dbpool);
    }

    private void loadDrivers() {
        ParseDSConfig pd = new ParseDSConfig();
        this.drivers = pd.readConfigInfo("config.properties");
        System.out.println("加载驱动程序。。。");
    }

    private void init() {
        this.loadDrivers();
        Iterator allDriver = this.drivers.iterator();
        while (allDriver.hasNext()) {
            this.createPools((DSConfigBean) allDriver.next());
            System.out.println("创建连接池");
        }
        System.out.println("创建连接池完毕");
    }

}
