package com.servlet;

import com.Model.MaterialModel;
import com.service.InformationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InformationServlet", urlPatterns = {"/InformationServlet"})
public class InformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了InformationServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String stock = req.getParameter("stock");
        System.out.println("name=" + name + "\nstock=" + stock);
        InformationService informationService = new InformationService();
        List<MaterialModel> modelList = informationService.getMaterial(name, stock);
        req.setAttribute("modelList", modelList);
        System.out.println(modelList);
        req.getRequestDispatcher("/jsp/warehouse_information.jsp").forward(req, resp);
    }
}
