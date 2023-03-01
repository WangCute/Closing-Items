package com.servlet;

import com.Model.ApplyModel;
import com.Model.LoginModel;
import com.service.ApplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 物资显示类
 */
@WebServlet("/ApplyServlet")
public class ApplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        ApplyService applyService = new ApplyService();

        HttpSession session = req.getSession();
        LoginModel loginModel = (LoginModel) session.getAttribute("login");
        String region_id = loginModel.getRegion_id();

        List<ApplyModel> applyList = applyService.getApply(region_id);
        req.setAttribute("applyList",applyList);
        req.getRequestDispatcher("/jsp/distribute_apply.jsp").forward(req,resp);

    }
}
