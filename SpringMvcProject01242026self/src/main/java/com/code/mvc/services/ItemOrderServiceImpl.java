package com.code.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.mvc.dao.ItemOrderDAO;
import com.code.mvc.entity.ItemOrder;
@Service
@Transactional
public class ItemOrderServiceImpl implements ItemOrderService {
@Autowired
ItemOrderDAO ioDAO;
	@Override
	public int add(ItemOrder itemOrder) {
		// TODO Auto-generated method stub
		return ioDAO.add(itemOrder);
	}

	@Override
	public int update(ItemOrder itemOrder) {
		// TODO Auto-generated method stub
		return ioDAO.update(itemOrder);
	}

	@Override
	public int delete(ItemOrder itemOrder) {
		// TODO Auto-generated method stub
		return ioDAO.delete(itemOrder);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return ioDAO.delete(id);
	}

	@Override
	public List<ItemOrder> getAll() {
		// TODO Auto-generated method stub
		return ioDAO.getAll();
	}

	@Override
	public ItemOrder getById(int id) {
		// TODO Auto-generated method stub
		return ioDAO.getById(id);
	}

}
