package com.DAO;

import com.Model.PersonalModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommunityPersonalDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 查询居民信息
    public List<PersonalModel> personalSelect(String region_id) {
        List<PersonalModel> list = new ArrayList<>();
        String sql = "select * from personal where region_id=?";
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, region_id);
            rst = pst.executeQuery();
            while (rst.next()){
                PersonalModel personalModel = new PersonalModel();
                personalModel.setId(rst.getInt(1));
                personalModel.setRegion_id(rst.getString(2));
                personalModel.setName(rst.getString(3));
                personalModel.setSex(rst.getString(4));
                personalModel.setAge(rst.getInt(5));
                personalModel.setCard_id(rst.getString(6));
                personalModel.setProvince(rst.getString(7));
                personalModel.setCity(rst.getString(8));
                personalModel.setCounty(rst.getString(9));
                personalModel.setTelephone(rst.getString(10));

                list.add(personalModel);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbUtil.closeMySQLConnection(connection, pst, rst);
        }
        return list;
    }

    // 查询人数
    public int personalCount(String region_id) {
        // 从数据库连接
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getMySQLConnection();
        String sql = "SELECT COUNT(*) FROM personal where region_id=?";
        int number = 0;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, region_id);
            rst = pst.executeQuery();
            while (rst.next()){
                number = rst.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbUtil.closeMySQLConnection(connection, pst, rst);
        }
        return number;
    }
}
