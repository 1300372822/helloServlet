package com.sgg.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 模拟数据库连接池
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();
}
