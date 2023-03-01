package com.servlet;

import com.Model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CommunityServlet", urlPatterns = {"/CommunityServlet"})
public class CommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断用户是否登录
        HttpSession session = req.getSession();
        LoginModel loginModel = (LoginModel) session.getAttribute("login");

        // 用户未登录
        if (loginModel == null || loginModel.getAccount() == null) {
            resp.sendRedirect("/jsp/organization_Login");
        }
    }
}
