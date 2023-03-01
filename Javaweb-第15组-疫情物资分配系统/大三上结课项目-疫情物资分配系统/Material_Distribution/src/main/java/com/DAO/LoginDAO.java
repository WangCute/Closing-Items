package com.DAO;

import com.Model.LoginModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 根据账号判断类型和地区编码
    public LoginModel getLoginByAccount(String account, String password) {
        LoginModel loginModel = new LoginModel();
        String sql = "SELECT * FROM login WHERE ACCOUNT = ? AND PASSWORD = ?";
        PreparedStatement pst = null;
        ResultSet rst = null;
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, account);
            pst.setString(2, password);
            // 3、执行查询操作
            rst = pst.executeQuery();
            // 从ResultSet中获取数据
            while (rst.next()){
                loginModel.setId(rst.getInt(1));
                loginModel.setAccount(rst.getString(2));
                loginModel.setPassword(rst.getString(3));
                loginModel.setRegion_id(rst.getString(4));
                loginModel.setType(rst.getString(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.closeMySQLConnection(connection, pst , rst);
        }

        return loginModel;
    }
}
