package com.service;

import com.DAO.WarehousDAO;
import com.Model.WarehousModel;

//物资入库
public class WarehousService {
    public int addWarehous(WarehousModel warehousModel){
        int r = 0;
        WarehousDAO warehousDAO = new WarehousDAO();
        r =warehousDAO.addWarehous(warehousModel);
        return r;
    }
}
