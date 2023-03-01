package com.service;

import com.DAO.ExamineAdoptDAO;

public class ExamineAdoptService {
    // 通过物资id修改物资状态
    public void updateApplyById(String id) {
        ExamineAdoptDAO examineAdoptDAO = new ExamineAdoptDAO();
        examineAdoptDAO.updateApplyById(id);
    }
}
