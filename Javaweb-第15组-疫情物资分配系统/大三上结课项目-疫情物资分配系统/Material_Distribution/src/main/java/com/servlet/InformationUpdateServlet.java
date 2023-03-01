package com.servlet;

import com.Model.MaterialModel;
import com.service.InformationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InformationUpdateServlet", urlPatterns = {"/InformationUpdateServlet"})
public class InformationUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了InformationUpdateServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        MaterialModel materialModel = new MaterialModel();
        materialModel.setName(req.getParameter("name"));
        materialModel.setType(req.getParameter("type"));
        materialModel.setValid(req.getParameter("valid"));
        materialModel.setInvalid(req.getParameter("invalid"));
        materialModel.setStock(Double.parseDouble(req.getParameter("stock")));
        materialModel.setCompany(req.getParameter("company"));

        String id = req.getParameter("id");
        System.out.println("id=" + id);
        InformationService informationService = new InformationService();
        informationService.updateMaterialById(materialModel, id);
        resp.sendRedirect("/InformationServlet");
    }
}
