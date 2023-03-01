package com.DAO;

import com.Model.DestructionModel;
import com.Model.MaterialModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DestructionDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 新增数据到物资销毁表中，同时减去物资信息表中库存量
    public boolean addDestruction(DestructionModel destructionModel) {
        String sqlMater = "SELECT stock FROM material WHERE CODE = ?";
        String sqlMaterial = "UPDATE material SET  stock = stock - ? WHERE CODE = ?";
        String sqlDestruction = "INSERT INTO destruction(NAME,CODE,TYPE,warehous,valid,invalid,NUMBER,company) SELECT" +
                " ?,?,TYPE,warehous,valid,invalid,?,company FROM material WHERE CODE = ?";
        PreparedStatement pst = null;
        ResultSet rst = null;
        try{
            // 查询物资信息表中的库存两
            pst = connection.prepareStatement(sqlMater);
            pst.setString(1, destructionModel.getCode());
            rst = pst.executeQuery();
            MaterialModel materialModel = new MaterialModel();
            while (rst.next()){
                materialModel.setStock(rst.getDouble(1));
            }
            // 是否超出库存中的数量
            if (destructionModel.getNumber() > materialModel.getStock()){
                return false;
            }

            // 减去物资信息的库存量
            pst = connection.prepareStatement(sqlMaterial);
            pst.setDouble(1, destructionModel.getNumber());
            pst.setString(2, destructionModel.getCode());
            pst.executeUpdate();

            // 新增数据到销毁数据表中
            pst = connection.prepareStatement(sqlDestruction);
            pst.setString(1, destructionModel.getName());
            pst.setString(2, destructionModel.getCode());
            pst.setDouble(3, destructionModel.getNumber());
            pst.setString(4, destructionModel.getCode());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.closeMySQLConnection(connection, pst, rst);
        }
        return true;
    }
}
