package com.service;

import com.DAO.DestructionDAO;
import com.Model.DestructionModel;

public class DestructionService {
    // 新增数据到物资销毁表中，同时减去物资信息表中库存量
    public boolean addDestruction(DestructionModel destructionModel) {
        DestructionDAO destructionDAO = new DestructionDAO();
        return destructionDAO.addDestruction(destructionModel);
    }
}
