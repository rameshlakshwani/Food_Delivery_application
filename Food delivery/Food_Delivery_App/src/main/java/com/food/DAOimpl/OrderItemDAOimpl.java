package com.food.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderItemDAO;
import com.food.Model.OrderItem;
import com.food.Utility.DBConnection;

public class OrderItemDAOimpl implements OrderItemDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO orderitem(OrderID,MenuID,Quantity,ItemTotal) VALUES(?,?,?,?)";

    private static final String SELECT_QUERY =
            "SELECT * FROM orderitem WHERE OrderItemID=?";

    private static final String UPDATE_QUERY =
            "UPDATE orderitem SET OrderID=?,MenuID=?,Quantity=?,ItemTotal=? WHERE OrderItemID=?";

    private static final String DELETE_QUERY =
            "DELETE FROM orderitem WHERE OrderItemID=?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM orderitem";

    @Override
    public void addOrderItem(OrderItem orderItem) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(INSERT_QUERY);

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItemTotal());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItem(int orderItemId) {

        OrderItem orderItem = null;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(SELECT_QUERY);

            pstmt.setInt(1, orderItemId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                orderItem = new OrderItem(
                        rs.getInt("OrderItemID"),
                        rs.getInt("OrderID"),
                        rs.getInt("MenuID"),
                        rs.getInt("Quantity"),
                        rs.getDouble("ItemTotal"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItem;
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(UPDATE_QUERY);

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItemTotal());
            pstmt.setInt(5, orderItem.getOrderItemId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int orderItemId) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(DELETE_QUERY);

            pstmt.setInt(1, orderItemId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getAllOrderItems() {

        List<OrderItem> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            Statement stmt = con.createStatement();

            ResultSet rs =
                    stmt.executeQuery(SELECT_ALL_QUERY);

            while (rs.next()) {

                OrderItem orderItem = new OrderItem(
                        rs.getInt("OrderItemID"),
                        rs.getInt("OrderID"),
                        rs.getInt("MenuID"),
                        rs.getInt("Quantity"),
                        rs.getDouble("ItemTotal"));

                list.add(orderItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {

        List<OrderItem> list = new ArrayList<>();

        String sql = "SELECT * FROM orderitem WHERE OrderID=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, orderId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                OrderItem item = new OrderItem(

                        rs.getInt("OrderItemID"),

                        rs.getInt("OrderID"),

                        rs.getInt("MenuID"),

                        rs.getInt("Quantity"),

                        rs.getDouble("ItemTotal"));

                list.add(item);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return list;
    }
}