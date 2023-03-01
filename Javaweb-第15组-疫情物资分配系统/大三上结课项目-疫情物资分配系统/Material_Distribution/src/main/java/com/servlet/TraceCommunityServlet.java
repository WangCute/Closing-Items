package com.servlet;

import com.Model.ApplyModel;
import com.Model.LoginModel;
import com.service.TraceCommunityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TraceCommunityServlet", urlPatterns = "/TraceCommunityServlet")
public class TraceCommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了TraceCommunityServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        // 根据订单状态、订单号和本地区编码查询物资申请表信息
        String order = req.getParameter("order");
        String state = req.getParameter("state");
        TraceCommunityService traceCommunityService = new TraceCommunityService();
        HttpSession session = req.getSession();
        LoginModel loginModel = (LoginModel) session.getAttribute("login");
        String region_id = loginModel.getRegion_id();
        System.out.println("region_id=" + region_id);
        System.out.println(order);
        System.out.println(state);
        List<ApplyModel> applyCommList = traceCommunityService.getApplyByStateOrder(state, order, region_id);
        // 显示到页面
        req.setAttribute("applyCommList", applyCommList);
        System.out.println(applyCommList);
        req.getRequestDispatcher("/jsp/community_trace.jsp").forward(req, resp);
    }
}
