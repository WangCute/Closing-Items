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

@WebServlet(name = "GrantAddServlet", urlPatterns = {"/GrantAddServlet"})
public class GrantAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        DistributeModel distributeModel = new DistributeModel();
        distributeModel.setName(req.getParameter("name"));
        distributeModel.setCode(req.getParameter("code"));
        distributeModel.setType(req.getParameter("type"));
        distributeModel.setNumber(Double.parseDouble(req.getParameter("number")));
        distributeModel.setOwner(req.getParameter("owner"));
        distributeModel.setCompany(req.getParameter("company"));
        distributeModel.setAddress(req.getParameter("address"));
        distributeModel.setTelephone(req.getParameter("telephone"));
        distributeModel.setCard_id(req.getParameter("card_id"));
        distributeModel.setTime(req.getParameter("time"));

        HttpSession session = req.getSession();
        LoginModel loginModel = (LoginModel) session.getAttribute("login");
        String region_id = loginModel.getRegion_id();

        GrantService grantService = new GrantService();
        grantService.distributeAdd(distributeModel, region_id);

        resp.sendRedirect("/GrantServlet");
    }
}
