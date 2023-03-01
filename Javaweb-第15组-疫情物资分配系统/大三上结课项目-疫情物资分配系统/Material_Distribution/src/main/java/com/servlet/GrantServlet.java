package com.servlet;

import com.Model.DistributeModel;
import com.Model.LoginModel;
import com.service.GrantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GrantServlet", urlPatterns = {"/GrantServlet"})
public class GrantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        LoginModel loginModel = (LoginModel) session.getAttribute("login");
        String region_id = loginModel.getRegion_id();

        GrantService grantService = new GrantService();
        List<DistributeModel> listDistribute = grantService.distributeSelectByRegionId(region_id);
        req.setAttribute("listDistribute", listDistribute);

        req.getRequestDispatcher("/jsp/distribute_grant.jsp").forward(req, resp);
    }
}
