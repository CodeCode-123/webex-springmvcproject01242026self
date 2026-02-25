package com.code.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.mvc.dao.ItemOrderDetailsDAO;
import com.code.mvc.entity.ItemOrderDetails;
@Service
@Transactional
public class ItemOrderDetailsServiceImpl implements ItemOrderDetailsService {
@Autowired
ItemOrderDetailsDAO ioddao;
	@Override
	public int add(ItemOrderDetails itemOrder) {
		// TODO Auto-generated method stub
		return ioddao.add(itemOrder);
	}

	@Override
	public int update(ItemOrderDetails itemOrder) {
		// TODO Auto-generated method stub
		return ioddao.update(itemOrder);
	}

	@Override
	public int delete(ItemOrderDetails itemOrder) {
		// TODO Auto-generated method stub
		return ioddao.delete(itemOrder);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return ioddao.delete(id);
	}

	@Override
	public List<ItemOrderDetails> getAll() {
		// TODO Auto-generated method stub
		return ioddao.getAll();
	}

	@Override
	public ItemOrderDetails getById(int id) {
		// TODO Auto-generated method stub
		return ioddao.getById(id);
	}

	@Override
	public List<ItemOrderDetails> getByOrderId(int id) {
		// TODO Auto-generated method stub
		return ioddao.getByOrderId(id);
	}

}
