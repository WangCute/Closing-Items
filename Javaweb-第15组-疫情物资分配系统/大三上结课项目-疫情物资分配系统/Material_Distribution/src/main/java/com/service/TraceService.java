package com.service;

import com.DAO.TraceDAO;
import com.Model.ApplyModel;

import java.util.ArrayList;
import java.util.List;

public class TraceService {
    // 根据是否有条件查询物资信息表中的数据
    public List<ApplyModel> getApplyByStateOrder(String state, String order) {
        TraceDAO traceDAO = new TraceDAO();
        List<ApplyModel> applyList = new ArrayList<>();
        applyList = traceDAO.getApplyByStateOrder(state, order);
        return applyList;
    }
}
