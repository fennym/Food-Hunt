package edu.utdallas.foodhunt.search.servlet;

import edu.utdallas.foodhunt.restaurantmanagement.businesslayer.RestaurantService;
import edu.utdallas.foodhunt.search.businesslayer.SearchService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchController extends HttpServlet {

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("restaurants", new SearchService().searchRestaurants(request.getParameter("keyword")));
        request.getRequestDispatcher("adminHome.jsp").forward(request, response);
    }
}
