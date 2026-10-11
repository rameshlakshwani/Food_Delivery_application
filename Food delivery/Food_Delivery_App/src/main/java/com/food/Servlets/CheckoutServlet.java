package com.food.Servlets;

import java.io.IOException;

import com.food.DAOimpl.OrderItemDAOimpl;
import com.food.DAOimpl.OrderTableDAOimpl;
import com.food.Model.Cart;
import com.food.Model.CartItem;
import com.food.Model.OrderItem;
import com.food.Model.OrderTable;
import com.food.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	System.out.println("CheckoutServlet Called");
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        // Check whether the user is logged in
        if (session == null || session.getAttribute("loggedInUser") == null) {
            resp.sendRedirect("login.html");
            return;
        }

        User user = (User) session.getAttribute("loggedInUser");
        Cart cart = (Cart) session.getAttribute("cart");

        // Check if the cart is empty
        if (cart == null || cart.getItems().isEmpty()) {
            resp.sendRedirect("cart.jsp");
            return;
        }

        // Get checkout details
        String address = req.getParameter("address");

        System.out.println("========== ORDER DETAILS ==========");
        System.out.println("Customer : " + user.getUsername());
        System.out.println("Email    : " + user.getEmail());
        System.out.println("Address  : " + address);
        System.out.println("Total    : ₹" + cart.getGrandTotal());
        System.out.println("===================================");

        // TODO:
        // Save OrderTable
        OrderTable order = new OrderTable();

        order.setUserId(user.getUserId());

        order.setRestaurantId(cart.getRestaurantId());

        order.setTotalAmount(cart.getGrandTotal());

        order.setStatus("Placed");

        order.setPaymentMethod("Cash On Delivery");

        OrderTableDAOimpl orderDAO = new OrderTableDAOimpl();
        
        System.out.println("UserID = " + user.getUserId());
        System.out.println("RestaurantID = " + cart.getRestaurantId());
        System.out.println("Total = " + cart.getGrandTotal());
        
        int orderId = orderDAO.addOrder(order);
        System.out.println("Generated Order ID = " + orderId);
        // Save OrderItems
        OrderItemDAOimpl orderItemDAO = new OrderItemDAOimpl();

        for(CartItem item : cart.getItems().values()){

            OrderItem orderItem = new OrderItem();

            orderItem.setOrderId(orderId);

            orderItem.setMenuId(item.getMenuId());

            orderItem.setQuantity(item.getQuantity());

            orderItem.setItemTotal(item.getTotalPrice());

            orderItemDAO.addOrderItem(orderItem);
        }

        // Clear cart after successful order
        cart.clearCart();
        session.setAttribute("cart", cart);

        resp.sendRedirect("ordersuccess.jsp");
    }
}