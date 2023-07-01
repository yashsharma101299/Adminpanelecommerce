package com.day8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PurchaseReports {
	@Id
	private int cartId;
	private int userId;
	private String date;
	private String time;
	private String modeofPayment;
	public PurchaseReports() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseReports(int cartId, int userId, String date, String time, String modeofPayment) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.date = date;
		this.time = time;
		this.modeofPayment = modeofPayment;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getModeofPayment() {
		return modeofPayment;
	}
	public void setModeofPayment(String modeofPayment) {
		this.modeofPayment = modeofPayment;
	}
	@Override
	public String toString() {
		return "PurchaseReports [cartId=" + cartId + ", userId=" + userId + ", date=" + date + ", time=" + time
				+ ", modeofPayment=" + modeofPayment + "]";
	}
	

}
