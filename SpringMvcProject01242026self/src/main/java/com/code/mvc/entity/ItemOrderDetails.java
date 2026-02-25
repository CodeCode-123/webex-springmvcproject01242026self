package com.code.mvc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item_order_details")
public class ItemOrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_order_id")
	int itemOrderId;
	@Column(name="product_name")
	String productName;
	@Column(name="category_name")
	String categoryName;
	@Column(name="price")
	double price;
	@Column(name="qty")
	int qty;
	@Column(name="item_value")
	double itemValue;
	@ManyToOne
	@JoinColumn(name="order_id")
	ItemOrder itemOrder;
	public  ItemOrderDetails() {
		
	}
	public int getItemOrderId() {
		return itemOrderId;
	}
	public void setItemOrderId(int itemOrderId) {
		this.itemOrderId = itemOrderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getItemValue() {
		return itemValue;
	}
	public void setItemValue(double itemValue) {
		this.itemValue = itemValue;
	}
	public ItemOrder getItemOrder() {
		return itemOrder;
	}
	public void setItemOrder(ItemOrder itemOrder) {
		this.itemOrder = itemOrder;
	}
}
