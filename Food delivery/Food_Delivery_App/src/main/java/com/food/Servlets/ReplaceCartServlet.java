package com.food.Servlets;

import java.io.IOException;

import com.food.DAOimpl.MenuDAOimpl;
import com.food.Model.Cart;
import com.food.Model.CartItem;
import com.food.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ReplaceCartServlet")
public class ReplaceCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session=req.getSession();

        Cart cart=(Cart)session.getAttribute("cart");

        int restaurantId=
                (Integer)session.getAttribute("newRestaurantId");

        int menuId=Integer.parseInt(
                (String)session.getAttribute("pendingMenuId"));

        int quantity=Integer.parseInt(
                (String)session.getAttribute("pendingQuantity"));

        cart.clearCart();

        cart.setRestaurantId(restaurantId);

        MenuDAOimpl dao=new MenuDAOimpl();

        Menu menu=dao.getMenu(menuId);

        CartItem item=new CartItem(

                menu.getMenuId(),

                menu.getRestaurantId(),

                menu.getItemName(),

                menu.getPrice(),

                quantity);

        cart.addItem(item);

        session.removeAttribute("newRestaurantId");
        session.removeAttribute("pendingMenuId");
        session.removeAttribute("pendingQuantity");

        resp.sendRedirect("cart.jsp");

    }

}