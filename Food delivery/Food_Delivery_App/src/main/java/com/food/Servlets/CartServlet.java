package com.food.Servlets;

import java.io.IOException;

import com.food.DAOimpl.MenuDAOimpl;
import com.food.Model.Cart;
import com.food.Model.CartItem;
import com.food.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req,
	        HttpServletResponse resp)
	        throws ServletException, IOException {

	    HttpSession session = req.getSession(false);

	    if (session == null || session.getAttribute("loggedInUser") == null) {
	        resp.sendRedirect("login.html");
	        return;
	    }

	    Cart cart = (Cart) session.getAttribute("cart");

	    int restaurantId =
	            Integer.parseInt(req.getParameter("restaurantId"));

	    if (cart == null) {

	        cart = new Cart();

	        cart.setRestaurantId(restaurantId);

	        session.setAttribute("cart", cart);

	    } else if(cart.getRestaurantId()!=restaurantId){

	        session.setAttribute("newRestaurantId", restaurantId);
	        session.setAttribute("pendingMenuId",
	                req.getParameter("menuId"));
	        session.setAttribute("pendingQuantity",
	                req.getParameter("quantity"));

	        resp.sendRedirect("confirmCart.jsp");
	        return;
	    }
	    String action = req.getParameter("action");

	    if (action == null) {
	        action = "add";
	    }

	    switch (action) {

	    case "add":
	        addItem(req, cart);
	        break;

	    case "update":
	        updateItem(req, cart);
	        break;

	    case "delete":
	        deleteItem(req, cart);
	        break;

	    case "clear":
	        cart.clearCart();
	        break;
	    }

	    session.setAttribute("cart", cart);

	    resp.sendRedirect("cart.jsp");
	}

    // ---------------- Add ----------------

    private void addItem(HttpServletRequest req,
            Cart cart) {

        int menuId = Integer.parseInt(req.getParameter("menuId"));

        int quantity = Integer.parseInt(req.getParameter("quantity"));

        MenuDAOimpl dao = new MenuDAOimpl();

        Menu menu = dao.getMenu(menuId);

        CartItem item = new CartItem(

                menu.getMenuId(),

                menu.getRestaurantId(),

                menu.getItemName(),

                menu.getPrice(),

                quantity);

        cart.addItem(item);

    }

    // ---------------- Update ----------------

    private void updateItem(HttpServletRequest req,
            Cart cart) {

        int menuId = Integer.parseInt(req.getParameter("menuId"));

        int quantity = Integer.parseInt(req.getParameter("quantity"));

        cart.updateItem(menuId, quantity);

    }

    // ---------------- Delete ----------------

    private void deleteItem(HttpServletRequest req,
            Cart cart) {

        int menuId = Integer.parseInt(req.getParameter("menuId"));

        cart.removeItem(menuId);

    }

}