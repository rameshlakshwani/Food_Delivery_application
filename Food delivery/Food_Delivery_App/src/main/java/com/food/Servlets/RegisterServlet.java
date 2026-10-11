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

@WebServlet("/callRegisterServlet")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		String address=req.getParameter("address");
		
		String hashpw=BCrypt.hashpw(password,BCrypt.gensalt(12));
		
		System.out.println("Username : " + name);
		System.out.println("Email    : " + email);
		System.out.println("Password : " + password);
		System.out.println("Address  : " + address);
		System.out.println("Role     : " + role);
		
		User user=new User(name,hashpw,email,address,role);
		UserDAOimpl userDAOimpl=new UserDAOimpl();
		int res = userDAOimpl.addUser(user);

		System.out.println(user);
		System.out.println("Rows inserted = " + res);

		if (res == 1) {
		    resp.sendRedirect("login.html");
		} else {
		    System.out.println("Registration failed");
		    resp.sendRedirect("register.html");
		}
	}
}
