package com.service;

import com.DAO.NoticeDAO;
import com.Model.NoticeModel;

import java.util.ArrayList;
import java.util.List;

public class NoticeService {
    NoticeDAO noticeDAO = new NoticeDAO();
    // 添加公告
    public void noticeAdd(String name, String content, String type, String time) {
        noticeDAO.noticeAdd(name, content, type, time);
    }

    // 查询公告
    public List<NoticeModel> noticeSelect() {
        List<NoticeModel> list = new ArrayList<>();
        list = noticeDAO.noticeSelect();
        return list;
    }

    // 根据id查看公告详细信息
    public NoticeModel noticeSelectById(String id) {
        return noticeDAO.noticeSelectById(id);
    }
}
