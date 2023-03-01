package com.DAO;

import com.Model.ApplyModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IssueDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 根据订单状态为查询物资申请表信息
    public List<ApplyModel> getApplyByState(String state) {
        System.out.println("连接成功！getApplyByState()");
        List<ApplyModel> applyList = new ArrayList<>();
        String sql = "select * from apply where state = ?";
        PreparedStatement pst = null;
        ResultSet rst = null;
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, state);
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

    // 根据物资编码将物资申请表中已审批的信息和物资信息表中的信息整合添加到物资出库表中，同时修改物资申请表中状态为已出库
    public void addIssue(String code) {
        String sqlApply = "update apply set state = '已出库' where code = ?";
        String sqlIssue = "INSERT INTO issue(NAME,CODE,TYPE,warehous,valid,invalid,NUMBER,company) " +
                "SELECT material.name,apply.code,material.type,material.warehous,material.valid,material.invalid,apply.number,material.company FROM apply " +
                "INNER JOIN material WHERE apply.code = ?";
        PreparedStatement pst = null;
        try{
            // 信息整合添加到物资出库表中
            pst = connection.prepareStatement(sqlIssue);
            pst.setString(1, code);
            pst.executeUpdate();

            // 修改物资申请表中状态为已出库
            pst = connection.prepareStatement(sqlApply);
            pst.setString(1, code);
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.closeMySQLConnection(connection, pst);
        }
    }

}
