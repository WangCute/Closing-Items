package com.servlet;

import com.Model.PersonalModel;
import com.service.PersonalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PersonalServlet", urlPatterns = {"/PersonalServlet"})
public class PersonalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        PersonalModel personalModel = new PersonalModel();
        personalModel.setName(req.getParameter("name"));
        personalModel.setSex(req.getParameter("sex"));
        personalModel.setAge(Integer.parseInt(req.getParameter("age")));
        personalModel.setCard_id(req.getParameter("card_id"));
        personalModel.setProvince(req.getParameter("province"));
        personalModel.setCity(req.getParameter("city"));
        personalModel.setCounty(req.getParameter("county"));
        personalModel.setAddress(req.getParameter("address"));
        personalModel.setTelephone(req.getParameter("telephone"));

        PersonalService personalService = new PersonalService();
        personalService.personalAdd(personalModel);
        resp.sendRedirect("/IndexServlet");
    }
}
