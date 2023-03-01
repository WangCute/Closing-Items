package com.DAO;

import com.Model.NoticeModel;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {
    // 从数据库连接
    DBUtil dbUtil = new DBUtil();
    Connection connection = dbUtil.getMySQLConnection();

    // 添加公告
    public void noticeAdd(String name, String content, String type, String time) {
        String sql = "insert into notice(name,content,type,time) values(?,?,?,?)";
        PreparedStatement pst =null;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, content);
            pst.setString(3, type);
            pst.setString(4, time);
            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbUtil.closeMySQLConnection(connection, pst);
        }
    }

    // 查询公告
    public List<NoticeModel> noticeSelect() {
        String sql = "select * from notice";
        List<NoticeModel> list = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            pst = connection.prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()){
                NoticeModel noticeModel = new NoticeModel();
                noticeModel.setId(rst.getInt(1));
                noticeModel.setName(rst.getString(2));
                noticeModel.setContent(rst.getString(3));
                noticeModel.setType(rst.getString(4));
                noticeModel.setTime(rst.getString(5));
                list.add(noticeModel);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    // 根据id查看公告详细信息
    public NoticeModel noticeSelectById(String id) {
        String sql = "select * from notice where id = ?";
        NoticeModel noticeModel = new NoticeModel();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, id);
            rst = pst.executeQuery();
            while (rst.next()){
                noticeModel.setName(rst.getString(1));
                noticeModel.setContent(rst.getString(2));
                noticeModel.setType(rst.getString(3));
                noticeModel.setTime(rst.getString(4));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return noticeModel;
    }
}
