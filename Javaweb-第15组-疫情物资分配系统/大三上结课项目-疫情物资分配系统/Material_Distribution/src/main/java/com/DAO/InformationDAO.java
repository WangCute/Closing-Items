package com.DAO;

import com.Model.MaterialModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 根据是否有条件查询物资信息表中的数据
    public List<MaterialModel> getMaterial(String name, String stock) {
        System.out.println("连接成功！getMaterial()");
        List<MaterialModel> materialList = new ArrayList<>();
        boolean flag = false;
        String sql = null;
        // 判断是否为第一次加载或空值查询
        if (name == null || name == ""){
            if (stock == null){
                sql = "select * from material";
            }else {
                sql = "select * from material where stock > 0";
            }
        }else if ((name.charAt(0) >= 'A' && name.charAt(0) <= 'Z') || (name.charAt(0) >= 'a' && name.charAt(0) <= 'z')){
            // 判断是否为编码(编码首字母为字母)
            if (stock == null){
                sql = "select * from material where code = ?";
            }else {
                sql = "select * from material where code = ? and stock > 0";
            }
            flag = true;
        }else {
            // 汉字
            if (stock == null) {
                sql = "select * from material where name = ?";
            }else {
                sql = "select * from material where name = ? and stock > 0";
            }
            flag = true;
        }
        PreparedStatement pst = null;
        ResultSet rst = null;
        try{
            pst = connection.prepareStatement(sql);
            if (flag != false){
                pst.setString(1, name);
            }
            // 执行查询操作
            rst = pst.executeQuery();
            while (rst.next()){
                MaterialModel materialModel = new MaterialModel();
                materialModel.setId(rst.getInt(1));
                materialModel.setName(rst.getString(2));
                materialModel.setCode(rst.getString(3));
                materialModel.setType(rst.getString(4));
                materialModel.setWarehous(rst.getString(5));
                materialModel.setValid(rst.getString(6));
                materialModel.setInvalid(rst.getString(7));
                materialModel.setStock(rst.getDouble(8));
                materialModel.setCompany(rst.getString(9));
                // 添加
                materialList.add(materialModel);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.closeMySQLConnection(connection, pst, rst);
        }
        System.out.println(materialList);
        return materialList;
    }

    // 根据物资id号修改信息
    public List<MaterialModel> updateMaterialById(MaterialModel materialModel, String id) {
        List<MaterialModel> materialList = new ArrayList<>();
        String sql = "update material set name=?,type=?,valid=?,invalid=?,stock=?,company=? where id=?";
        PreparedStatement pst = null;
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, materialModel.getName());
            pst.setString(2, materialModel.getType());
            pst.setString(3, materialModel.getValid());
            pst.setString(4, materialModel.getInvalid());
            pst.setDouble(5, materialModel.getStock());
            pst.setString(6, materialModel.getCompany());
            pst.setString(7, id);

            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.closeMySQLConnection(connection, pst);
        }
        return materialList;
    }
}
