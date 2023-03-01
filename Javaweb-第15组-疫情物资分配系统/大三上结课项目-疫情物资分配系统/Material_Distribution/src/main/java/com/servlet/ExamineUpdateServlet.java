package com.servlet;

import com.Model.ApplyModel;
import com.service.ExamineService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExamineUpdateServlet", urlPatterns = {"/ExamineUpdateServlet"})
public class ExamineUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了InformationUpdateServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        ApplyModel applyModel = new ApplyModel();
        applyModel.setName(req.getParameter("name"));
        applyModel.setCode(req.getParameter("code"));
        applyModel.setType(req.getParameter("type"));
        applyModel.setNumber(Double.parseDouble(req.getParameter("number")));
        applyModel.setCompany(req.getParameter("company"));

        String id = req.getParameter("id");
        System.out.println("id=" + id);
        ExamineService examineService = new ExamineService();
        examineService.updateApplyById(applyModel, id);
        resp.sendRedirect("/ExamineServlet");
    }
}
