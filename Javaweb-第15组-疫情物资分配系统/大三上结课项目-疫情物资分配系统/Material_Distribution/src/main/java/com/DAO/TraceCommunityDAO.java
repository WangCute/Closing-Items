package com.DAO;

import com.Model.ApplyModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraceCommunityDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 根据订单状态为查询物资申请表信息
    public List<ApplyModel> getApplyByStateOrder(String state, String order, String region_id) {
        System.out.println("连接成功！getApplyByStateOrder()");
        List<ApplyModel> applyList = new ArrayList<>();
        String sql = null;
        int temp = 0;
        if (state == null){
            sql = "select * from apply where region_id=?";
        }else if (order != ""){
            sql = "select * from apply where region_id=? and apply.order=?";
            temp = 1;
        }else if (state.equals("待审批") || state.equals("已审批") || state.equals("已出库") || state.equals("已签收")){
            sql = "select * from apply where region_id=? and state=?";
            temp = 2;
        }else {
            sql = "select * from apply where region_id=?";
        }
        PreparedStatement pst = null;
        ResultSet rst = null;
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, region_id);
            if (temp == 1){
                pst.setString(2, order);
            }else if (temp == 2){
                pst.setString(2, state);
            }

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
}
