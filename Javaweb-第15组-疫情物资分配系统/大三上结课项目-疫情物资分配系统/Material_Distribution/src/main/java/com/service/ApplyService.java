package com.service;

import com.DAO.ApplyDAO;
import com.Model.ApplyModel;

import java.sql.SQLException;
import java.util.List;

public class ApplyService {
    ApplyDAO applyDAO = new ApplyDAO();

    /**
     * 获取所有物资列表
     * @return
     * @throws SQLException
     */
    public List<ApplyModel> getApply(String region_id) {
        return applyDAO.getApply(region_id);
    }

    /**
     * 添加申请表的物资
     * @param apply
     * @return
     * @throws SQLException
     */
    public void insert(ApplyModel apply, String region_id) {
        applyDAO.insert(apply, region_id);
    }
}
