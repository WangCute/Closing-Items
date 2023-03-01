package com.service;

import com.DAO.IssueDAO;
import com.Model.ApplyModel;

import java.util.ArrayList;
import java.util.List;

public class IssueService {
    IssueDAO issueDAO = new IssueDAO();
    // 根据订单状态为已审批查询物资申请表信息
    public List<ApplyModel> getApplyByState(String state) {
        List<ApplyModel> applyList = new ArrayList<>();
        applyList = issueDAO.getApplyByState(state);
        return applyList;
    }

    // 根据物资编码将物资申请表中已审批的信息和物资信息表中的信息整合添加到物资出库表中
    public void addIssue(String code){
        issueDAO.addIssue(code);
    }
}
