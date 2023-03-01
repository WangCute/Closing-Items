package com.service;

import com.DAO.TraceCommunityDAO;
import com.Model.ApplyModel;

import java.util.ArrayList;
import java.util.List;

public class TraceCommunityService {
    // 根据是否有条件查询物资信息表中的数据
    public List<ApplyModel> getApplyByStateOrder(String state, String order, String region_id) {
        TraceCommunityDAO traceCommunityDAO = new TraceCommunityDAO();
        List<ApplyModel> applyList = new ArrayList<>();
        applyList = traceCommunityDAO.getApplyByStateOrder(state, order, region_id);
        return applyList;
    }
}
