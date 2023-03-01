package com.servlet;

import com.service.ExamineAdoptService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExamineAdoptServlet", urlPatterns = {"/ExamineAdoptServlet"})
public class ExamineAdoptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了ExamineAdoptServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        ExamineAdoptService examineAdoptService = new ExamineAdoptService();
        examineAdoptService.updateApplyById(id);
        resp.sendRedirect("/ExamineServlet");
    }
}
