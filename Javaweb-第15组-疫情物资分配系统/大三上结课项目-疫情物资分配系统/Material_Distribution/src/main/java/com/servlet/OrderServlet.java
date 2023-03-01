package com.servlet;


import com.Model.ApplyModel;
import com.Model.LoginModel;
import com.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        LoginModel loginModel = (LoginModel) session.getAttribute("login");
        String region_id = loginModel.getRegion_id();

        OrderService orderService = new OrderService();
        List<ApplyModel> listApply = orderService.applySelectByStateRegionId("已出库", region_id);

        req.setAttribute("listApply", listApply);

        req.getRequestDispatcher("/jsp/community_sign.jsp").forward(req, resp);

    }
}
