package com.DAO;

import com.Model.DistributeModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrantDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 查询物资分发表
    public List<DistributeModel> distributeSelectByRegionId(String region_id) {
        String sql = "select * from distribute where region_id = ?";
        List<DistributeModel> list = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, region_id);
            rst = pst.executeQuery();
            while (rst.next()){
                DistributeModel distributeModel = new DistributeModel();
                distributeModel.setId(rst.getInt(1));
                distributeModel.setRegion_id(rst.getString(2));
                distributeModel.setName(rst.getString(3));
                distributeModel.setCode(rst.getString(4));
                distributeModel.setType(rst.getString(5));
                distributeModel.setNumber(rst.getDouble(6));
                distributeModel.setCompany(rst.getString(7));
                distributeModel.setOwner(rst.getString(8));
                distributeModel.setAddress(rst.getString(9));
                distributeModel.setTelephone(rst.getString(10));
                distributeModel.setCard_id(rst.getString(11));
                distributeModel.setTime(rst.getString(12));
                list.add(distributeModel);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbUtil.closeMySQLConnection(connection, pst, rst);
        }
        return list;
    }

    // 新增物资分发表信息
    public void distributeAdd(DistributeModel distributeModel, String region_id) {
        String sql = "insert into distribute(region_id,name,code,type,number,company,owner,address,telephone,card_id,time) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, region_id);
            pst.setString(2, distributeModel.getName());
            pst.setString(3, distributeModel.getCode());
            pst.setString(4, distributeModel.getType());
            pst.setDouble(5, distributeModel.getNumber());
            pst.setString(6, distributeModel.getCompany());
            pst.setString(7, distributeModel.getOwner());
            pst.setString(8, distributeModel.getAddress());
            pst.setString(9, distributeModel.getTelephone());
            pst.setString(10, distributeModel.getCard_id());
            pst.setString(11, distributeModel.getTime());

            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbUtil.closeMySQLConnection(connection, pst);
        }
    }
}
