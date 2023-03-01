package com.service;

import com.DAO.PersonalDAO;
import com.Model.PersonalModel;

public class PersonalService {
    PersonalDAO personalDAO = new PersonalDAO();

    // 添加个人信息登记
    public void personalAdd(PersonalModel personalModel) {
        personalDAO.personalAdd(personalModel);
    }
}
