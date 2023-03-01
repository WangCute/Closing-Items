package com.service;

import com.DAO.LoginDAO;
import com.Model.LoginModel;

public class LoginService {
    // 根据账号判断类型和地区编码
    // 0：账号不存在或密码错误
    // 1：中央账号
    // 2：社区账号
    public LoginModel getLoginByAccount(String account, String password) {
        LoginDAO loginDAO = new LoginDAO();
        LoginModel loginModel = loginDAO.getLoginByAccount(account, password);
        return loginModel;
    }
}
