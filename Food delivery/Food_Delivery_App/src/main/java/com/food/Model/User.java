package com.food.Model;

import java.sql.Timestamp;

public class User {
	
		private int userId;
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		private String userName;
		private String password;
		private String email;
		private String address;
		private String role;
		private Timestamp createDate;
		private Timestamp loginDate;

		public User() {
	
		}
		public User(String userName, String password, String email, String address, String role) {
			super();
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.address = address;
			this.role = role;
		}
		public User(int userId, String userName, String password, String email, String address, String role,
				Timestamp createDate, Timestamp loginDate) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.address = address;
			this.role = role;
			this.createDate = createDate;
			this.loginDate = loginDate;
		}
		public String getUsername() {
			return userName;
		}
		public void setUsername(String username) {
			this.userName = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Timestamp getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Timestamp createdDate) {
			this.createDate = createDate;
		}
		public Timestamp getLoginDate() {
			return loginDate;
		}
		public void setLoginDate(Timestamp loginDate) {
			this.loginDate = loginDate;
			
		}
		@Override
		public String toString() {
			return "User [userName=" + userName + ", password=" + password + ", email=" + email + ", address=" + address
					+ ", role=" + role + ", createDate=" + createDate + ", loginDate=" + loginDate + "]";
		}
		
	}

