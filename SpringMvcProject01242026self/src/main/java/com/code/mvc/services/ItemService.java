package com.code.mvc.services;

import java.util.List;

import com.code.mvc.entity.Item;

public interface ItemService {
	public int add(Item item);
	public int update(Item item);
	public int delete(Item item);
	public int delete(int id);
	//create some method to get the student
	public List<Item> getAll();
	public Item getById(int id);
}
