package com.service;

import com.DAO.OrderDAO;
import com.Model.ApplyModel;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    OrderDAO orderDAO = new OrderDAO();

    //查询订单信息（已出库，本地区编码）
    public List<ApplyModel> applySelectByStateRegionId(String state, String region_id) {
        List<ApplyModel> list = new ArrayList<>();
        list = orderDAO.applySelectByStateRegionId(state, region_id);
        return list;
    }

    // 根据id修改状态为已出库
    public void applyUpdateByState(String id) {
        orderDAO.applyUpdateByState(id);
    }
}
