package com.food.Servlets;

import java.io.IOException;
import java.util.List;

import com.food.DAOimpl.MenuDAOimpl;
import com.food.Model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    HttpSession session = req.getSession(false);

	    if (session == null || session.getAttribute("loggedInUser") == null) {
	        resp.sendRedirect("login.html");
	        return;
	    }

	    MenuDAOimpl menuDAOimpl = new MenuDAOimpl();

	    int restaurantID = Integer.parseInt(req.getParameter("restaurantID"));

	    List<Menu> allMenusByRestaurant =
	            menuDAOimpl.getAllMenusByRestaurant(restaurantID);

	    req.setAttribute("allMenusByRestaurant", allMenusByRestaurant);

	    RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");

	    rd.forward(req, resp);
	}
}
