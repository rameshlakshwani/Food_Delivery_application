package com.food.Servlets;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.food.DAOimpl.UserDAOimpl;
import com.food.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/callLoginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDAOimpl userDAO = new UserDAOimpl();
	
		User user = userDAO.getUserByEmail(email);

		if (user == null) {
		    System.out.println("User not found");
		    resp.sendRedirect("login.html");
		    return;
		}

		if (BCrypt.checkpw(password, user.getPassword())) {

		    HttpSession session = req.getSession(true);

		    session.setAttribute("loggedInUser", user);

		    System.out.println("Login Successful");
		    System.out.println("Session ID : " + session.getId());
		    

		    resp.sendRedirect("callRestaurantServlet");

		} else {

		    System.out.println("Wrong Password");
		    resp.sendRedirect("login.html");
		}
		
	}
}
