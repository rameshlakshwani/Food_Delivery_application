package com.food.Servlets;

import java.io.IOException;
import java.util.List;

import com.food.DAOimpl.OrderTableDAOimpl;
import com.food.Model.OrderTable;
import com.food.Model.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session==null ||
           session.getAttribute("loggedInUser")==null){

            resp.sendRedirect("login.html");
            return;
        }

        User user =
        (User)session.getAttribute("loggedInUser");
        
        System.out.println("Logged In User ID = " + user.getUserId());
        System.out.println("Logged In Username = " + user.getUsername());

        OrderTableDAOimpl dao =
                new OrderTableDAOimpl();

        System.out.println("OrderHistoryServlet called");

        List<OrderTable> orders = dao.getOrdersByUserId(user.getUserId());

        System.out.println("Orders size = " + orders.size());

        for(OrderTable o : orders){
            System.out.println(o);
        }

        req.setAttribute("orders", orders);

        RequestDispatcher rd =
        req.getRequestDispatcher("orderhistory.jsp");

        rd.forward(req, resp);

    }

}