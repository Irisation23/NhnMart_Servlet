package com.nhnacademy.mart.servlet;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", urlPatterns = "/login", initParams = {
    @WebInitParam(name = "id", value = "gg"),
    @WebInitParam(name = "pwd", value = "12")
})
public class LoginServlet extends HttpServlet {
    private String configId;
    private String configPwd;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        configId = config.getInitParameter("id");
        configPwd = config.getInitParameter("pwd");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if(Objects.isNull(session)){
            resp.sendRedirect("/login.html");
        } else {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
//            RequestDispatcher rd = req.getRequestDispatcher("/init");
//            rd.forward(req,resp);
            resp.sendRedirect("/init");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if(configId.equals(id) && configPwd.equals(pwd)){
            HttpSession session = req.getSession(false);
            if(Objects.nonNull(session)){
               session.invalidate();
            }
            session = req.getSession(true);
            session.setAttribute("id",id);


//            RequestDispatcher rd = req.getRequestDispatcher("/login");
//            rd.forward(req,resp); 요청이 공유되어 다시 doPost로 가는 현상이 발생함.

            resp.sendRedirect("/login");
        }else {
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.forward(req,resp);
            //resp.sendRedirect("/login.html");
        }

    }
}
