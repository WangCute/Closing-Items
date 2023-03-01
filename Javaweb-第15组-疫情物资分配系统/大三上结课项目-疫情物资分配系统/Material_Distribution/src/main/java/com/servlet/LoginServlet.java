package com.servlet;

import com.Model.LoginModel;
import com.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了LoginServlet！");
        // 处理中文乱码问题
        req.setCharacterEncoding("utf-8");

        String account = req.getParameter("account");
        String password = req.getParameter("password");

        LoginService loginService = new LoginService();
        LoginModel loginModel = loginService.getLoginByAccount(account, password);
        if (loginModel.getAccount() != null){
            if (loginModel.getType().equals("中央")){
                resp.sendRedirect("/jsp/government.jsp");
            }
            else{
                // 使用Session保存用户信息
                HttpSession session = req.getSession();
                loginModel.setRegion_id(loginModel.getRegion_id());
                session.setAttribute("login", loginModel);

                resp.sendRedirect("/jsp/community.jsp");
            }
        }else{
            req.setAttribute("account","登录失败，账号不存在或密码错误！");
            req.getRequestDispatcher("/jsp/organization_Login.jsp").forward(req, resp);
        }
    }
}
