package com.code.mvc.dao;

import com.code.mvc.entity.Users;
import java.util.*;

public interface IUserDao {
	// create the method for the users
	public int addUser(Users users);
	public int updateUser(Users users);
	public int deleteUser(Users users);
	public int deleteUser(int userId);
	public Users getUserById(int userId);
	public Users getUserAuthentication(String emailId, String password);
	public List<Users> searchUserByName(String keyword);
	public List<Users> getAll();
}
