package com.service;

import com.DAO.GrantDAO;
import com.Model.DistributeModel;

import java.util.ArrayList;
import java.util.List;

public class GrantService {
    GrantDAO grantDAO = new GrantDAO();
    // 查询物资分发表
    public List<DistributeModel> distributeSelectByRegionId(String region_id) {
        List<DistributeModel> list = new ArrayList<>();
        list = grantDAO.distributeSelectByRegionId(region_id);
        return list;
    }

    // 新增物资分发表信息
    public void distributeAdd(DistributeModel distributeModel, String region_id) {
        grantDAO.distributeAdd(distributeModel, region_id);
    }
}
