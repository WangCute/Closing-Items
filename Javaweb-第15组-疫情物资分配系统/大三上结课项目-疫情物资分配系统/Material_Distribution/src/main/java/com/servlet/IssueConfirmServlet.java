package com.servlet;

import com.service.IssueService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IssueConfirmServlet", urlPatterns = {"/IssueConfirmServlet"})
public class IssueConfirmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了IssueConfirmServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        String code = req.getParameter("code");
        System.out.println("code=" + code);
        IssueService issueService = new IssueService();
        issueService.addIssue(code);
        resp.sendRedirect("/IssueServlet");
    }
}
