package com.code.mvc.services;

import java.util.List;

import com.code.mvc.entity.ItemOrderDetails;

public interface ItemOrderDetailsService {
	public int add(ItemOrderDetails itemOrder);
	public int update(ItemOrderDetails itemOrder);
	public int delete(ItemOrderDetails itemOrder);
	public int delete(int id);
	//create some method to get the student
	public List<ItemOrderDetails> getAll();
	public List<ItemOrderDetails> getByOrderId(int id);
	public ItemOrderDetails getById(int id);
}
