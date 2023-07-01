package com.day8.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users_Table")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name="Name",nullable = false,length = 25)
	private String userName;
	@Column(name="Email",nullable = false,length = 25)
	private String userEmail;
	@Column(name="Password",nullable = false,length = 25)
	private String userPassword;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String userName, String userEmail, String userPassword) {
		super();
		
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + "]";
	}
	
	
	
	
	
	
}
