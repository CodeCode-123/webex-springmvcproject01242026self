package com.code.mvc.services;

import java.util.List;

import com.code.mvc.entity.ItemOrder;
import com.code.mvc.entity.ItemOrderDetails;

public interface ItemOrderService {
	public int add(ItemOrder itemOrder);
	public int update(ItemOrder itemOrder);
	public int delete(ItemOrder itemOrder);
	public int delete(int id);
	//create some method to get the student
	public List<ItemOrder> getAll();

	public ItemOrder getById(int id);
}
