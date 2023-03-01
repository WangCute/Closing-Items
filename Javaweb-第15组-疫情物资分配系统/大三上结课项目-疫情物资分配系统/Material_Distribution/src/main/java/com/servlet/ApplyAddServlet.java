package com.servlet;

import com.Model.ApplyModel;
import com.Model.LoginModel;
import com.service.ApplyService;
import com.util.GenerateNum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 物资申请类
 */
@WebServlet("/ApplyAddServlet")
public class ApplyAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String code = req.getParameter("code");
        String type = req.getParameter("type");
        String number = req.getParameter("number");
        String company = req.getParameter("company");
        String people = req.getParameter("people");
        String urgency = req.getParameter("urgency");
        String apply_date = req.getParameter("apply_date");
        GenerateNum generateNum = new GenerateNum();
        ApplyModel apply = new ApplyModel();
        apply.setOrder(generateNum.getInstance().GenerateOrder());
        apply.setName(name);
        apply.setCode(code);
        apply.setType(type);
        apply.setNumber(Double.parseDouble(number));
        apply.setCompany(company);
        apply.setPeople(Integer.parseInt(people));
        apply.setUrgency(urgency);
        apply.setApply_date(apply_date);

        HttpSession session = req.getSession();
        LoginModel loginModel = (LoginModel) session.getAttribute("login");
        String region_id = loginModel.getRegion_id();

        ApplyService applyService = new ApplyService();
        applyService.insert(apply,  region_id);
        resp.sendRedirect("/ApplyServlet");
    }
}
