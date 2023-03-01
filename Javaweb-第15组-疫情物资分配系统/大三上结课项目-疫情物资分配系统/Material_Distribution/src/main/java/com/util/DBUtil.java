package com.util;

import java.sql.*;

public class DBUtil {
    // MySQL数据库驱动
    private String driver = "com.mysql.jdbc.Driver";
    // 数据库连接URL
    private String url = "jdbc:mysql://127.0.0.1:3306/material_distribution";
    // 数据库用户名
    private String user = "root";
    // 数据库密码
    private String password = "0564335.";

    public Connection getMySQLConnection() {
        // 定义一个Connection对象
        Connection connection = null;
        // 注册MySQL数据库驱动
        try {
            Class.forName(driver);
            // 获取连接
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("连接成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        // 返回连接
        return connection;
    }

    // 关闭连接（Connection）
    public void closeMySQLConnection (Connection connection){
        if (connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    // 关闭连接（Connection 、PrepareStatement）
    public void closeMySQLConnection(Connection connection, PreparedStatement pst){
        if (pst != null){
            try{
                pst.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        closeMySQLConnection(connection);
    }

    // 关闭连接（Connection 、PrepareStatement 、ResultSet）
    public void closeMySQLConnection(Connection connection, PreparedStatement pst, ResultSet rst){
        if (rst != null){
            try{
                rst.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        closeMySQLConnection(connection ,pst);
    }
    // 关闭连接（Connection 、ResultSet）
    public void closeMySQLConnection(Connection connection, ResultSet rst){
        if (rst != null){
            try{
                rst.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        closeMySQLConnection(connection);
    }
}
