package com.service;

import com.DAO.InformationDAO;
import com.Model.MaterialModel;

import java.util.ArrayList;
import java.util.List;

public class InformationService {
    InformationDAO informationDAO = new InformationDAO();
    // 根据是否有条件查询物资信息表中的数据
    public List<MaterialModel> getMaterial(String name, String stock) {
        List<MaterialModel> materialList = new ArrayList<>();
        materialList = informationDAO.getMaterial(name, stock);
        return materialList;
    }

    // 根据物资id号修改信息
    public List<MaterialModel> updateMaterialById(MaterialModel materialModel, String id) {
        List<MaterialModel> materialList = new ArrayList<>();
        materialList = informationDAO.updateMaterialById(materialModel, id);
        return materialList;
    }
}
