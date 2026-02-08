package com.code.mvc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.code.mvc.dao.IUserDao;
import com.code.mvc.entity.Users;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	private final IUserDao userDao;
	@Autowired
	public UserServiceImpl(IUserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public int addUser(Users users) {
		// TODO Auto-generated method stub
		return userDao.addUser(users);
	}

	@Override
	public int updateUser(Users users) {
		// TODO Auto-generated method stub
		return userDao.updateUser(users);
	}

	@Override
	public int deleteUser(Users users) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(users);
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}

	@Override
	public Users getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userId);
	}

	@Override
	public Users getUserAuthentication(String emailId, String password) {
		// TODO Auto-generated method stub
		return userDao.getUserAuthentication(emailId, password);
	}

	@Override
	public List<Users> searchUserByName(String keyword) {
		// TODO Auto-generated method stub
		return userDao.searchUserByName(keyword);
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

}
