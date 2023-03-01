package com.DAO;

import com.Model.ApplyModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 查询订单信息（已出库，本地区编码）
    public List<ApplyModel> applySelectByStateRegionId(String state, String region_id) {
        List<ApplyModel> list = new ArrayList<>();
        String sql = "select * from apply where state = ? and region_id = ?";
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, state);
            pst.setString(2, region_id);
            rst = pst.executeQuery();
            while (rst.next()){
                ApplyModel applyModel = new ApplyModel();
                applyModel.setId(rst.getInt(1));
                applyModel.setOrder(rst.getString(2));
                applyModel.setRegion_id(rst.getString(3));
                applyModel.setName(rst.getString(4));
                applyModel.setCode(rst.getString(5));
                applyModel.setType(rst.getString(6));
                applyModel.setNumber(rst.getDouble(7));
                applyModel.setCompany(rst.getString(8));
                applyModel.setPeople(rst.getInt(9));
                applyModel.setUrgency(rst.getString(10));
                applyModel.setState(rst.getString(11));
                applyModel.setApply_date(rst.getString(12));
                list.add(applyModel);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbUtil.closeMySQLConnection(connection, pst, rst);
        }
        return list;
    }

    // 根据id修改状态为已出库
    public void applyUpdateByState(String id) {
        String sql = "update apply set state = '已签收' where id = ?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbUtil.closeMySQLConnection(connection, pst);
        }
    }
}
