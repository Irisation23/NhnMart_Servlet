package com.nhnacademy.mart.servlet;

import com.nhnacademy.mart.foodstand.Food;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodsServlet extends HttpServlet {
    List<Food> foodList;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext servletContext = getServletContext();
        foodList = (List<Food>) servletContext.getAttribute("foodList");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

       try(PrintWriter out = resp.getWriter()){
           for (Food food : foodList) {
               out.println(food.toString());
           }

           String pickedCart =
               "<form method = \"post\" action = \"/cart\">" +
                   "Onion : <input type = \"text\" name = \"onion\"><br>" +
                   "Egg : <input type = \"text\" name = \"egg\"><br>" +
                   "GreenOnion : <input type = \"text\" name = \"greenOnion\"><br>" +
                   "Apple : <input type = \"text\" name = \"apple\">" +
                   "<input type = \"submit\" />" +
                   "</form>";

           out.println(pickedCart);

       }




    }
}
