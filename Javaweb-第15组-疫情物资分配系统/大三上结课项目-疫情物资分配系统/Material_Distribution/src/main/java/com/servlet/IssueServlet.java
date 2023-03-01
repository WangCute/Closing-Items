package com.servlet;

import com.Model.ApplyModel;
import com.service.IssueService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IssueServlet", urlPatterns = {"/IssueServlet"})
public class IssueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了IssueServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");
        // 根据订单状态为已审批查询物资申请表信息
        IssueService issueService = new IssueService();
        List<ApplyModel> applyList = issueService.getApplyByState("已审批");
        // 显示到页面
        req.setAttribute("applyList", applyList);
        System.out.println(applyList);
        req.getRequestDispatcher("/jsp/warehouse_issue.jsp").forward(req, resp);
    }
}
