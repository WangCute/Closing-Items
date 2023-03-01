package com.servlet;

import com.Model.ApplyModel;
import com.service.ExamineService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExamineServlet", urlPatterns = {"/ExamineServlet"})
public class ExamineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了IssueServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        // 根据订单状态为待审批和订单号查询物资申请表信息
        String order = req.getParameter("order");
        ExamineService examineService = new ExamineService();
        List<ApplyModel> applyList = examineService.getApplyByStateOrder("待审批", order);
        // 显示到页面
        req.setAttribute("applyList", applyList);
        System.out.println(applyList);
        req.getRequestDispatcher("/jsp/distribution_examine.jsp").forward(req, resp);
    }
}
