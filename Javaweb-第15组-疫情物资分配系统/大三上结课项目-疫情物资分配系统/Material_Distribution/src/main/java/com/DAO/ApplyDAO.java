package com.DAO;

import com.Model.ApplyModel;
import com.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplyDAO {
    /**
     * 获取数据库distribute表的所有数据
     * @return
     * @throws SQLException
     */
    public List<ApplyModel> getApply(String region_id) {
        ArrayList<ApplyModel> applyList = new ArrayList<>();
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getMySQLConnection();
        System.out.println("regin_id:" + region_id);
        String sql = "select * from apply where region_id=?";
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, region_id);
            rst = pst.executeQuery();
            while (rst.next()){
                ApplyModel apply = new ApplyModel();
                apply.setId(Integer.parseInt(rst.getString("id")));
                apply.setOrder(rst.getString("order"));
                apply.setRegion_id(rst.getString("region_id"));
                apply.setName(rst.getString("name"));
                apply.setCode(rst.getString("code"));
                apply.setType(rst.getString("type"));
                apply.setNumber(Double.parseDouble(rst.getString("number")));
                apply.setCompany(rst.getString("company"));
                apply.setPeople(Integer.parseInt(rst.getString("people")));
                apply.setUrgency(rst.getString("urgency"));
                apply.setState(rst.getString("state"));
                apply.setApply_date(rst.getString("apply_date"));
                applyList.add(apply);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.closeMySQLConnection(connection, pst, rst);
        }
        return applyList;
    }

    /**
     * 向数据库添加申请物资数据
     * @param apply
     * @return
     * @throws SQLException
     */
    public void insert(ApplyModel apply, String region_id) {
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getMySQLConnection();
        String sql = "insert into apply(apply.order,region_id,name,code,type,number,company,people,urgency,apply_date) " +
                "values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,apply.getOrder());
            pst.setString(2,region_id);
            pst.setString(3,apply.getName());
            pst.setString(4,apply.getCode());
            pst.setString(5,apply.getType());
            pst.setDouble(6,apply.getNumber());
            pst.setString(7,apply.getCompany());
            pst.setInt(8,apply.getPeople());
            pst.setString(9,apply.getUrgency());
            pst.setString(10,apply.getApply_date());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.closeMySQLConnection(connection, pst);
        }
    }
}
