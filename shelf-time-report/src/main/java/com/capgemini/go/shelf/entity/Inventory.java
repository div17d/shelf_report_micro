package com.capgemini.go.shelf.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="inventory")
public class Inventory {
	@Id
	@Column(name = "product_id")
	String productID;
	
	@Column(name="product_catagory")
	String productCatagory;
	
	@Column(name = "product_name")
	String productName;
	
	@Column(name = "product_price")
	int productPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="receive_time")
	Date receiveTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sale_time")
	Date saleTime;
	
	@Column(name = "user_id")
	String userID;
		
		
		public Inventory(String productID, String productCatagory, String productName, int productPrice,
			Date receiveTime, Date saleTime, String userID) {
		super();
		this.productID = productID;
		this.productCatagory = productCatagory;
		this.productName = productName;
		this.productPrice = productPrice;
		this.receiveTime = receiveTime;
		this.saleTime = saleTime;
		this.userID = userID;
	}
		public String getUserID() {
			return userID;
		}



		public void setUserID(String userID) {
			this.userID = userID;
		}



		public String getProductID() {
		return productID;
		}
		
		
		public void setProductID(String productID) {
		this.productID = productID;
		}



	public String getProductCatagory() {
		return productCatagory;
	}



	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public int getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}



	public Date getReceiveTime() {
		return receiveTime;
	}



	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}



	public Date getSaleTime() {
		return saleTime;
	}



	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}



		public Inventory() {
			super();
		}
		
		
	}



