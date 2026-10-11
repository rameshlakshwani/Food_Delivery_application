package com.food.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.UserDAO;
import com.food.Model.User;
import com.food.Utility.DBConnection;

public class UserDAOimpl implements UserDAO{
	
	private static final String INSERT_QUERY="INSERT INTO user(userName,password,email,address,role,"+" createDate,loginDate) Values(?,?,?,?,?,?,?)";
	
	private static final String SELECT_QUERY="SELECT * FROM user where userId=?";
	
	private static final String UPDATE_QUERY="UPDATE user SET userName=?,password=?,email=?,"+"address=?,loginDate=? where userId=?";
	
	private static final String DELETE_QUERY="DELETE FROM user WHERE userId=?";
	
	private static final String SELECT_ALL_QUERY="SELECT * FROM user";
	@Override
//	public void addUser(User user) {
	public int addUser(User user) {
		
		//String INSERT_QUERY="INSERT INTO user(userName,password,email,address,role,"+" createDate,loginDate) Values(?,?,?,?,?,?,?)";
	
		Connection con=DBConnection.getConnection();
		
		try {
		PreparedStatement pstmt =con.prepareStatement(INSERT_QUERY);
		
		
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getAddress());
		pstmt.setString(5, user.getRole()); 
		pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
		pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
		int i=pstmt.executeUpdate();
		return i;
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User getUser(int userId) {
		User user=null;
		Connection connection=DBConnection.getConnection();
		try {
			PreparedStatement pstmt=connection.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1,userId);
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				int id=res.getInt("userId");
				String userName=res.getString("userName");
				String password=res.getString("password");
				String email=res.getString("email");
				String address=res.getString("address");
				String role=res.getString("role");
				Timestamp createDate=res.getTimestamp("createDate");
				Timestamp loginDate=res.getTimestamp("loginDate");
				
				user =new User(userId,userName,  password, email,  address, role,
						 createDate, loginDate);
			} 
		
		}catch(SQLException e) {

		    System.out.println("Error Code : " + e.getErrorCode());
		    System.out.println("SQL State  : " + e.getSQLState());
		    System.out.println("Message    : " + e.getMessage());

		    e.printStackTrace();

		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		
		Connection connection=DBConnection.getConnection();
		try {
			PreparedStatement pstmt=connection.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.setLong(6,user.getUserId());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userId) {
		Connection connection=DBConnection.getConnection();
		try {
			PreparedStatement pstmt=connection.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1,userId);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		Connection connection=DBConnection.getConnection();
		List<User> list=new ArrayList<User>();
		try {
			Statement stmt=connection.createStatement();
			ResultSet res=stmt.executeQuery(SELECT_ALL_QUERY);
			while(res.next()) {
				int id=res.getInt("userId");
				String userName=res.getString("userName");
				String password=res.getString("password");
				String email=res.getString("email");
				String address=res.getString("address");
				String role=res.getString("role");
				Timestamp createDate=res.getTimestamp("createDate");
				Timestamp loginDate=res.getTimestamp("loginDate");
				
				User user =new User(id,userName,  password, email,  address, role,
						 createDate, loginDate);
				list.add(user);
			} 
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public User getUserByEmail(String email) {

	    User user = null;

	    String sql = "SELECT * FROM user WHERE email = ?";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt = con.prepareStatement(sql);

	        pstmt.setString(1, email);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {

	            user = new User();

	            user.setUserId(rs.getInt("userId"));
	            user.setUsername(rs.getString("userName"));
	            user.setPassword(rs.getString("password"));
	            user.setEmail(rs.getString("email"));
	            user.setAddress(rs.getString("address"));
	            user.setRole(rs.getString("role"));
	            user.setCreateDate(rs.getTimestamp("createDate"));
	            user.setLoginDate(rs.getTimestamp("loginDate"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}

}
