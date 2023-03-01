package com.service;

import com.DAO.ExamineDAO;
import com.DAO.IssueDAO;
import com.Model.ApplyModel;

import java.util.ArrayList;
import java.util.List;

public class ExamineService {
    ExamineDAO examineDAO = new ExamineDAO();
    // 根据是否有条件查询物资信息表中的数据
    public List<ApplyModel> getApplyByStateOrder(String state, String order) {
        IssueDAO issueDAO = new IssueDAO();
        List<ApplyModel> applyList = new ArrayList<>();
        if (order == null || order == ""){
            applyList = issueDAO.getApplyByState(state);
        }else {
            applyList = examineDAO.getApplyByOrder(state, order);
        }
        return applyList;
    }

    // 根据物资id号修改信息
    public void updateApplyById(ApplyModel applyModel, String id) {
        examineDAO.updateApplyById(applyModel, id);
    }
}
