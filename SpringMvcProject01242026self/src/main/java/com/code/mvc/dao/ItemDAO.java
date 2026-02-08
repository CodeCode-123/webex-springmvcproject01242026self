package com.code.mvc.dao;

import java.util.List;

import com.code.mvc.entity.Category;
import com.code.mvc.entity.Item;

public interface ItemDAO {
	public int add(Item item);
	public int update(Item item);
	public int delete(Item item);
	public int delete(int id);
	//create some method to get the student
	public List<Item> getAll();
	public Item getById(int id);
	public List<Item> getItemByCategoryName(String categoryname);
	public List<Item> getItemByCategoryId(int id);
}
