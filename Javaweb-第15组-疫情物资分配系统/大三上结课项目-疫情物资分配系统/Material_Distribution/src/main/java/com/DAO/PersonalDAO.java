package com.DAO;

import com.Model.PersonalModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 添加个人信息登记
    public void personalAdd(PersonalModel personalModel) {
        String sql = "select region_id from regioncode where province=? and city=? and county=?";
        PreparedStatement pst = null;
        ResultSet rst = null;
        String region_id = null;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, personalModel.getProvince());
            pst.setString(2, personalModel.getCity());
            pst.setString(3, personalModel.getCounty());
            rst = pst.executeQuery();
            while (rst.next()){
                region_id = rst.getString(1);
            }

            sql = "insert into personal(region_id,name,sex,age,card_id,province,city,county,address,telephone) values(?,?,?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, region_id);
            pst.setString(2, personalModel.getName());
            pst.setString(3, personalModel.getSex());
            pst.setInt(4, personalModel.getAge());
            pst.setString(5, personalModel.getCard_id());
            pst.setString(6, personalModel.getProvince());
            pst.setString(7, personalModel.getCity());
            pst.setString(8, personalModel.getCounty());
            pst.setString(9, personalModel.getAddress());
            pst.setString(10, personalModel.getTelephone());
            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbUtil.closeMySQLConnection(connection, pst, rst);
        }
    }
}
