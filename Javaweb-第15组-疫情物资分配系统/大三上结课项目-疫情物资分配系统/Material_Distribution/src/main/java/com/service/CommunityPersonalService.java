package com.service;

import com.DAO.CommunityPersonalDAO;
import com.Model.PersonalModel;

import java.util.ArrayList;
import java.util.List;

public class CommunityPersonalService {
    CommunityPersonalDAO communityPersonalDAO = new CommunityPersonalDAO();

    // 查询居民信息
    public List<PersonalModel> personalSelect(String region_id) {
        List<PersonalModel> list = new ArrayList<>();
        list = communityPersonalDAO.personalSelect(region_id);
        return list;
    }

    // 查询人数
    public int personalCount(String region_id) {
        return communityPersonalDAO.personalCount(region_id);
    }
}
