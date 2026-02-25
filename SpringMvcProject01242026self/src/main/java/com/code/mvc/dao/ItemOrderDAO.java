package com.code.mvc.dao;

import java.util.List;

import com.code.mvc.entity.Category;
import com.code.mvc.entity.Item;
import com.code.mvc.entity.ItemOrder;

public interface ItemOrderDAO {
	public int add(ItemOrder itemOrder);
	public int update(ItemOrder itemOrder);
	public int delete(ItemOrder itemOrder);
	public int delete(int id);
	//create some method to get the student
	public List<ItemOrder> getAll();
	public ItemOrder getById(int id);
}
