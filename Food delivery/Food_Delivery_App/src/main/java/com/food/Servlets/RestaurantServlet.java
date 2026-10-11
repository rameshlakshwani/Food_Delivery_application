package com.food.Servlets;

import java.io.IOException;
import java.util.List;

import com.food.DAOimpl.RestaurantDAOimpl;
import com.food.Model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/callRestaurantServlet")
public class RestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Check whether the user is logged in
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("loggedInUser") == null) {
            resp.sendRedirect("login.html");
            return;
        }

        try {

            RestaurantDAOimpl restaurantDAOimpl = new RestaurantDAOimpl();

            List<Restaurant> allRestaurants =
                    restaurantDAOimpl.getAllRestaurants();

            req.setAttribute("allRestaurants", allRestaurants);

            RequestDispatcher rd =
                    req.getRequestDispatcher("restaurant.jsp");

            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}