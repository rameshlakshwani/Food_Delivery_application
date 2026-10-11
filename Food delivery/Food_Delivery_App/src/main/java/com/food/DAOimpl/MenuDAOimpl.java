package com.food.DAOimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.MenuDAO;
import com.food.Model.Menu;
import com.food.Utility.DBConnection;

public class MenuDAOimpl implements MenuDAO {

	private static final String INSERT_QUERY =
			"INSERT INTO menu(RestaurantID,ItemName,Description,Price,IsAvailable,Category,ImagePath,Rating,DeliveryTime,CreatedAt,UpdatedAt) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_QUERY =
            "SELECT * FROM menu WHERE MenuID=?";

    private static final String UPDATE_QUERY =
            "UPDATE menu SET RestaurantID=?,ItemName=?,Description=?,Price=?,IsAvailable=?,Category=?,UpdatedAt=? WHERE MenuID=?";

    private static final String DELETE_QUERY =
            "DELETE FROM menu WHERE MenuID=?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM menu";
    
    private static final String SELECT_BY_RESTAURANT_QUERY =
            "SELECT * FROM menu WHERE RestaurantID=?";

    @Override
    public void addMenu(Menu menu) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isAvailable());
            pstmt.setString(6, menu.getCategory());
            pstmt.setString(7, menu.getImagePath());
            pstmt.setDouble(8, menu.getRating());
            pstmt.setInt(9, menu.getDeliveryTime());

            Timestamp now = new Timestamp(System.currentTimeMillis());

            pstmt.setTimestamp(10, now);
            pstmt.setTimestamp(11, now);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenu(int menuId) {

        Menu menu = null;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(SELECT_QUERY);

            pstmt.setInt(1, menuId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

            	menu = new Menu(
            	        rs.getInt("MenuID"),
            	        rs.getInt("RestaurantID"),
            	        rs.getString("ItemName"),
            	        rs.getString("Description"),
            	        rs.getDouble("Price"),
            	        rs.getBoolean("IsAvailable"),
            	        rs.getString("Category"),
            	        rs.getString("ImagePath"),
            	        rs.getDouble("Rating"),
            	        rs.getInt("DeliveryTime"),
            	        rs.getTimestamp("CreatedAt"),
            	        rs.getTimestamp("UpdatedAt"),
            	        rs.getTimestamp("DeletedAt"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menu;
    }

    @Override
    public void updateMenu(Menu menu) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(UPDATE_QUERY);

            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isAvailable());
            pstmt.setString(6, menu.getCategory());
            pstmt.setTimestamp(7,
                    new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(8, menu.getMenuId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int menuId) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(DELETE_QUERY);

            pstmt.setInt(1, menuId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getAllMenus() {

        List<Menu> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            Statement stmt = con.createStatement();

            ResultSet rs =
                    stmt.executeQuery(SELECT_ALL_QUERY);

            while (rs.next()) {

            	Menu menu = new Menu(
            	        rs.getInt("MenuID"),
            	        rs.getInt("RestaurantID"),
            	        rs.getString("ItemName"),
            	        rs.getString("Description"),
            	        rs.getDouble("Price"),
            	        rs.getBoolean("IsAvailable"),
            	        rs.getString("Category"),
            	        rs.getString("ImagePath"),
            	        rs.getDouble("Rating"),
            	        rs.getInt("DeliveryTime"),
            	        rs.getTimestamp("CreatedAt"),
            	        rs.getTimestamp("UpdatedAt"),
            	        rs.getTimestamp("DeletedAt"));
                list.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<Menu> getAllMenusByRestaurant(int restaurantId) {

        List<Menu> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(SELECT_BY_RESTAURANT_QUERY);

            pstmt.setInt(1, restaurantId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

            	Menu menu = new Menu(
            	        rs.getInt("MenuID"),
            	        rs.getInt("RestaurantID"),
            	        rs.getString("ItemName"),
            	        rs.getString("Description"),
            	        rs.getDouble("Price"),
            	        rs.getBoolean("IsAvailable"),
            	        rs.getString("Category"),
            	        rs.getString("ImagePath"),
            	        rs.getDouble("Rating"),
            	        rs.getInt("DeliveryTime"),
            	        rs.getTimestamp("CreatedAt"),
            	        rs.getTimestamp("UpdatedAt"),
            	        rs.getTimestamp("DeletedAt"));
                list.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}