package com.DAO;

import com.Model.WarehousModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WarehousDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    //物资入库
    public int addWarehous(WarehousModel warehousModel){
        int r = 0;
        double stock = 0;
        String id = null;
        String sql= null;
        System.out.println("进入数据库链接");
        PreparedStatement pst = null;
        //SQL语句进行编译
        //进行查询code列出现相同code增加数量，没有项目code就新增数据
        String selectsql = "select id,stock from material where code=?";
        ResultSet rst = null;
        try{
            pst = connection.prepareStatement(selectsql);
            pst.setString(1, warehousModel.getCode());
            rst = pst.executeQuery();
            while (rst.next()){
                id = rst.getString(1);
                stock = rst.getDouble(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(stock);
        boolean st = false;
        if (id == null){
            sql = "insert into material(name,code,type,warehous,valid,invalid,stock,company) values(?,?,?,?,?,?,?,?)";
            st = true;
        }else {
            sql = "update material set stock = ? where code = ?";
        }

        try{
            pst = connection.prepareStatement(sql);
            if (st == true){
                pst.setString(1,warehousModel.getName());
                pst.setString(2,warehousModel.getCode());
                pst.setString(3,warehousModel.getType());
                pst.setString(4,warehousModel.getWarehous());
                pst.setString(5,warehousModel.getValid());
                pst.setString(6,warehousModel.getInvalid());
                pst.setDouble(7,warehousModel.getNumber());
                pst.setString(8,warehousModel.getCompany());
            }else {
                stock += warehousModel.getNumber();
                pst.setDouble(1, stock);
                pst.setString(2, warehousModel.getCode());
            }
            r = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (st == true){
            sql = "insert into warehous(name,code,type,warehous,valid,invalid,number,company) values(?,?,?,?,?,?,?,?)";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1,warehousModel.getName());
                pst.setString(2,warehousModel.getCode());
                pst.setString(3,warehousModel.getType());
                pst.setString(4,warehousModel.getWarehous());
                pst.setString(5,warehousModel.getValid());
                pst.setString(6,warehousModel.getInvalid());
                pst.setDouble(7,warehousModel.getNumber());
                pst.setString(8,warehousModel.getCompany());
                r = pst.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        dbUtil.closeMySQLConnection(connection, pst, rst);
        return r;
    }
}
