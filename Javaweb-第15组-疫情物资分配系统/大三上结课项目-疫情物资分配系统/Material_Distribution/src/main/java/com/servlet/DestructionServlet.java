package com.servlet;

import com.Model.DestructionModel;
import com.service.DestructionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DestructionServlet", urlPatterns = {"/DestructionServlet"})
public class DestructionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了DestructionServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        DestructionModel destructionModel = new DestructionModel();
        destructionModel.setName(req.getParameter("name"));
        destructionModel.setCode(req.getParameter("code"));
        destructionModel.setNumber(Double.parseDouble(req.getParameter("number")));
        destructionModel.setCompany(req.getParameter("company"));

        DestructionService destructionService = new DestructionService();
        boolean number = destructionService.addDestruction(destructionModel);
        req.setAttribute("number", number);
        req.getRequestDispatcher("/jsp/warehouse_destruction.jsp").forward(req, resp);
    }
}
