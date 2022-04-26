package com.nhnacademy.mart.servlet;


import com.nhnacademy.mart.foodstand.Apple;
import com.nhnacademy.mart.foodstand.Egg;
import com.nhnacademy.mart.foodstand.Food;
import com.nhnacademy.mart.foodstand.FoodStand;
import com.nhnacademy.mart.foodstand.GreenOnion;
import com.nhnacademy.mart.foodstand.Onion;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;

public class InitServlet extends HttpServlet {
    FoodStand foodStand;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        foodStand = new FoodStand();
        Food apple = new Apple(Integer.parseInt(getServletContext().getInitParameter("apple")));
        foodStand.fillInFood(apple);
        Food egg = new Egg(Integer.parseInt(getServletContext().getInitParameter("egg")));
        foodStand.fillInFood(egg);
        Food greenOnion = new GreenOnion(Integer.parseInt(getServletContext().getInitParameter("greenOnion")));
        foodStand.fillInFood(greenOnion);
        Food onion = new Onion(Integer.parseInt(getServletContext().getInitParameter("onion")));
        foodStand.fillInFood(onion);

        ServletContext servletContext = getServletContext();

        servletContext.setAttribute("foodList", foodStand.getFoodList());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try(PrintWriter out = resp.getWriter()){

            out.println(Jsoup.parse("<a href=\"http://localhost:8080/foods\">FoodStand</a>"));
        }
    }
}
