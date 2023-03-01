package com.servlet;

import com.Model.ApplyModel;
import com.service.TraceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TraceServlet", urlPatterns = {"/TraceServlet"})
public class TraceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了TraceServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        // 根据订单状态和订单号查询物资申请表信息
        String order = req.getParameter("order");
        String state = req.getParameter("state");
        TraceService traceService = new TraceService();
        List<ApplyModel> applyList = traceService.getApplyByStateOrder(state, order);
        // 显示到页面
        req.setAttribute("applyList", applyList);
        System.out.println(applyList);
        req.getRequestDispatcher("/jsp/distribution_trace.jsp").forward(req, resp);
    }
}
