package com.DAO;

import com.Model.ApplyModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamineDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 根据订单状态和订单号查询物资申请表信息
    public List<ApplyModel> getApplyByOrder(String name, String order) {
        System.out.println("连接成功！getApplyByOrder()");
        List<ApplyModel> applyList = new ArrayList<>();
        String sql = "SELECT * FROM apply WHERE state = ? AND apply.order = ?";
        PreparedStatement pst = null;
        ResultSet rst = null;
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, order);
            // 执行查询操作
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
                // 添加
                applyList.add(applyModel);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.closeMySQLConnection(connection, pst, rst);
        }
        System.out.println(applyList);
        return applyList;
    }

    // 根据id修改物资申请表信息
    public void updateApplyById(ApplyModel applyModel, String id) {
        String sql = "update apply set name=?,code=?,type=?,number=?,company=? where id=?";
        PreparedStatement pst = null;
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, applyModel.getName());
            pst.setString(2, applyModel.getCode());
            pst.setString(3, applyModel.getType());
            pst.setDouble(4, applyModel.getNumber());
            pst.setString(5, applyModel.getCompany());
            pst.setString(6, id);

            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.closeMySQLConnection(connection, pst);
        }
    }
}
