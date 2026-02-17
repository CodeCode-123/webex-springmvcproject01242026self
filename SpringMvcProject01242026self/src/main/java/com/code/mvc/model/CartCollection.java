package com.code.mvc.model;

import java.util.*;

public class CartCollection {
	// collection
	List<Cart> items = new ArrayList<>();
	// create some methods
	public int addToCart(Cart item) {
		int flag=0; //item not added
		boolean result=checkDuplicateItem(item);
		if (result==false) {
			items.add(item);
			flag=1; //item added
		}
		return flag;
	}
	private boolean checkDuplicateItem(Cart item) {
		boolean found = false;
		for (Cart item2: items) {
			if (item2.getItemId()==item.getItemId()) {
				found=true;
				break;
			}
		}
		return found;
	}
	// delete from cart
	public boolean deleteFromCart(int itemId) {
		boolean found=false; // record is not deleted
		for (Cart item2: items) {
			if (item2.getItemId()==itemId) {
				// remove from the list
				items.remove(item2);
				found=true; // record is deleted
				break;
			}
		}
		return found;
	}
	// update cart
	public boolean updateCart(Cart item) {
		boolean found=false; // record is not updated
		for (Cart item2: items) {
			if (item2.getItemId() == item.getItemId()) {
				item2.setQty(item.getQty());
				found=true; // record is updated
				break;
			}
		}
		return found;
	}
	// get items from cart
	public List<Cart> getAll() {
		return items;
	}
	// get total item number in the cart
	public int getTotalItem() {
		return items.size();
	}
	// get Total Price
	public double getTotalAmount() {
		double totalPrice=0;
		for(Cart item2: items) {
			totalPrice += item2.getAmount();
		}
		return totalPrice;
	}
}
