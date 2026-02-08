package com.code.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.mvc.dao.ItemDAO;
import com.code.mvc.entity.Item;
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
		@Autowired
		ItemDAO itemdao;
	@Override
	public int add(Item item) {
		// TODO Auto-generated method stub
		return itemdao.add(item);
	}

	@Override
	public int update(Item item) {
		// TODO Auto-generated method stub
		return itemdao.update(item);
	}

	@Override
	public int delete(Item item) {
		// TODO Auto-generated method stub
		return itemdao.delete(item);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return itemdao.delete(id);
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return itemdao.getAll();
	}

	@Override
	public Item getById(int id) {
		// TODO Auto-generated method stub
		return itemdao.getById(id);
	}

}
