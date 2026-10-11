package com.food.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderTableDAO;
import com.food.Model.OrderTable;
import com.food.Utility.DBConnection;

public class OrderTableDAOimpl implements OrderTableDAO {

	private static final String INSERT_QUERY =
			"INSERT INTO ordertable(UserID,RestaurantID,OrderDate,TotalAmount,Status,PaymentMethod) VALUES(?,?,?,?,?,?)";
    private static final String SELECT_QUERY =
            "SELECT * FROM ordertable WHERE OrderID=?";

    private static final String UPDATE_QUERY =
            "UPDATE ordertable SET UserID=?,RestaurantID=?,TotalAmount=?,Status=?,PaymentMethod=? WHERE OrderID=?";

    private static final String DELETE_QUERY =
            "DELETE FROM ordertable WHERE OrderID=?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM ordertable";

    @Override
    public int addOrder(OrderTable order) {

        int orderId = 0;

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt = con.prepareStatement(
                    INSERT_QUERY,
                    Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getRestaurantId());
            pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentMethod());

            pstmt.executeUpdate();
            System.out.println("Order inserted successfully");

            ResultSet rs = pstmt.getGeneratedKeys();

            if(rs.next()){

                orderId = rs.getInt(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderId;
    }

    @Override
    public OrderTable getOrder(int orderId) {

        OrderTable order = null;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(SELECT_QUERY);

            pstmt.setInt(1, orderId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                order = new OrderTable(
                        rs.getInt("OrderID"),
                        rs.getInt("UserID"),
                        rs.getInt("RestaurantID"),
                        rs.getTimestamp("OrderDate"),
                        rs.getDouble("TotalAmount"),
                        rs.getString("Status"),
                        rs.getString("PaymentMethod"));
            }

        } catch (SQLException e) {
        	System.out.println("Order Insert Error");
        	e.printStackTrace();
        }

        return order;
    }

    @Override
    public void updateOrder(OrderTable order) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(UPDATE_QUERY);

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getRestaurantId());
            pstmt.setDouble(3, order.getTotalAmount());
            pstmt.setString(4, order.getStatus());
            pstmt.setString(5, order.getPaymentMethod());
            pstmt.setInt(6, order.getOrderId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(DELETE_QUERY);

            pstmt.setInt(1, orderId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderTable> getAllOrders() {

        List<OrderTable> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            Statement stmt = con.createStatement();

            ResultSet rs =
                    stmt.executeQuery(SELECT_ALL_QUERY);

            while (rs.next()) {

                OrderTable order = new OrderTable(
                        rs.getInt("OrderID"),
                        rs.getInt("UserID"),
                        rs.getInt("RestaurantID"),
                        rs.getTimestamp("OrderDate"),
                        rs.getDouble("TotalAmount"),
                        rs.getString("Status"),
                        rs.getString("PaymentMethod"));

                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<OrderTable> getOrdersByUserId(int userId) {

        List<OrderTable> list = new ArrayList<>();

        String sql = "SELECT * FROM ordertable WHERE UserID=? ORDER BY OrderDate DESC";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                OrderTable order = new OrderTable(

                        rs.getInt("OrderID"),

                        rs.getInt("UserID"),

                        rs.getInt("RestaurantID"),

                        rs.getTimestamp("OrderDate"),

                        rs.getDouble("TotalAmount"),

                        rs.getString("Status"),

                        rs.getString("PaymentMethod"));

                list.add(order);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return list;
    }
}