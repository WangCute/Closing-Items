package com.servlet;

import com.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NoticeAddServlet", urlPatterns = {"/NoticeAddServlet"})
public class NoticeAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String content = req.getParameter("content");
        String type = req.getParameter("type");
        String time = req.getParameter("time");

        NoticeService noticeService = new NoticeService();
        noticeService.noticeAdd(name, content, type, time);

        req.getRequestDispatcher("/jsp/government.jsp").forward(req, resp);
    }
}
