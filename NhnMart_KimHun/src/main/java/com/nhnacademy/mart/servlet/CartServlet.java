package com.nhnacademy.mart.servlet;

import com.nhnacademy.mart.foodstand.Apple;
import com.nhnacademy.mart.foodstand.Basket;
import com.nhnacademy.mart.foodstand.Egg;
import com.nhnacademy.mart.foodstand.Food;
import com.nhnacademy.mart.foodstand.GreenOnion;
import com.nhnacademy.mart.foodstand.Onion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
@WebServlet(name = "cartServlet" , urlPatterns = "/cart" )
public class CartServlet extends HttpServlet {
    List<Food> foodList;
    int totalAmount;
    Basket basket;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();
        foodList = (List<Food>) servletContext.getAttribute("foodList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {

        int onionNum = Integer.parseInt(req.getParameter("onion"));
        int eggNum = Integer.parseInt(req.getParameter("egg"));
        int appleNum = Integer.parseInt(req.getParameter("apple"));
        int greenOnionNum = Integer.parseInt(req.getParameter("greenOnion"));

        Food onion = new Onion(onionNum);
        Food egg = new Egg(eggNum);
        Food apple = new Apple(appleNum);
        Food greenOnion = new GreenOnion(greenOnionNum);

        List<Food> buyList = new ArrayList<>();

        buyList.add(apple);
        buyList.add(egg);
        buyList.add(greenOnion);
        buyList.add(onion);

        basket = new Basket();
        basket.pickupFood(buyList);

        // 갯수가 넘지 않는지 확인.
        if(!basket.checkMaxFoodNum(foodList)) {
            resp.sendError(405 , " 매장 진열 수량보다 많이 담았습니다. ");
        }

        // 계산 할 금액.
        totalAmount = basket.calcToMoney(foodList);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try(PrintWriter out = resp.getWriter()){

            out.println(Jsoup.parse("<a href=\"http://localhost:8080/cart\">Basket</a>"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try(PrintWriter out = resp.getWriter()){
            for (Food food : basket.getBasketFoods()) {
                out.println(food.toString());
            }
            out.println("Total Money : " + totalAmount);
        }
    }
}
