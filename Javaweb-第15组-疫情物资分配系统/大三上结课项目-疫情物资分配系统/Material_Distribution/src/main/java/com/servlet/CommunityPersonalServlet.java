package com.servlet;

import com.Model.LoginModel;
import com.Model.PersonalModel;
import com.service.CommunityPersonalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CommunityPersonalServlet", urlPatterns = {"/CommunityPersonalServlet"})
public class CommunityPersonalServlet extends HttpServlet {
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

        CommunityPersonalService communityPersonalService = new CommunityPersonalService();
        List<PersonalModel> listPersonal = communityPersonalService.personalSelect(region_id);
        int number = communityPersonalService.personalCount(region_id);

        req.setAttribute("listPersonal", listPersonal);
        req.setAttribute("number", number);

        req.getRequestDispatcher("/jsp/community_personal.jsp").forward(req, resp);
    }
}
