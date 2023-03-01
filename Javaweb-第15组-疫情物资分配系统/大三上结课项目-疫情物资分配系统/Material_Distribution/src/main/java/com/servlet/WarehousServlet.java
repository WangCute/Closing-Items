package com.servlet;

import com.Model.WarehousModel;
import com.service.WarehousService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WarehousServlet", urlPatterns = {"/WarehousServlet"})
public class WarehousServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        System.out.println("进入新增");
        //获取输入数据
        WarehousModel warehousModel = new WarehousModel();
        warehousModel.setName(req.getParameter("name"));
        warehousModel.setCode(req.getParameter("code"));
        warehousModel.setType(req.getParameter("type"));
        warehousModel.setWarehous(req.getParameter("warehous"));
        warehousModel.setValid(req.getParameter("valid"));
        warehousModel.setInvalid(req.getParameter("invalid"));
        warehousModel.setNumber(Double.parseDouble(req.getParameter("number")));
        warehousModel.setCompany(req.getParameter("company"));
        //信息保存
        System.out.println(warehousModel.getName());
        WarehousService warehousService = new WarehousService();
        int r = warehousService.addWarehous(warehousModel);
        //数据刷新
        resp.sendRedirect("/jsp/warehouse_into.jsp");
    }
}
