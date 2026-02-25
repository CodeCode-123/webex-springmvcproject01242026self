package com.code.mvc.dao;

import java.util.List;

import com.code.mvc.entity.Category;
import com.code.mvc.entity.Item;
import com.code.mvc.entity.ItemOrder;
import com.code.mvc.entity.ItemOrderDetails;

public interface ItemOrderDetailsDAO {
	public int add(ItemOrderDetails itemOrder);
	public int update(ItemOrderDetails itemOrder);
	public int delete(ItemOrderDetails itemOrder);
	public int delete(int id);
	//create some method to get the student
	public List<ItemOrderDetails> getAll();
	public List<ItemOrderDetails> getByOrderId(int id);
	public ItemOrderDetails getById(int id);
}
