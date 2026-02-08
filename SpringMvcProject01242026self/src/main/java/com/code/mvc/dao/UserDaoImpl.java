package com.code.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.code.mvc.entity.Users;

@Repository
public class UserDaoImpl implements IUserDao {
	// add the dependency
	private final SessionFactory sessionFactory;
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public int addUser(Users users) {
		// TODO Auto-generated method stub
		// create the session object
		Session session=sessionFactory.getCurrentSession();
		// save the object
		session.save(users);
		return users.getId();
	}

	@Override
	public int updateUser(Users users) {
		// TODO Auto-generated method stub
		// create the session object
		Session session=sessionFactory.getCurrentSession();
		int id = users.getId();
		if (session.get(Users.class, id) != null) {
			// update the object
			session.merge(users);
		}
		return users.getId();
	}

	@Override
	public int deleteUser(Users users) {
		// TODO Auto-generated method stub
		// create the session object
		Session session=sessionFactory.getCurrentSession();
		int id = users.getId();
		if (session.get(Users.class, id) != null) {
			// remove the object
			session.remove(users);
			return 1; // deleted the users
		}
		return 0; // not deleted the users
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		// create the session object
		Session session = sessionFactory.getCurrentSession();
		Users users = session.get(Users.class, userId);
		if (users != null) {
			// remove the object
			session.remove(users);
			return 1;  // deleted the users
		}
		return 0;  // not deleted the users
	}

	@Override
	public Users getUserById(int userId) {
		// TODO Auto-generated method stub
		// create the session object
		Session session = sessionFactory.getCurrentSession();
		// return the retrieved object 
		return session.get(Users.class, userId);
	}

	@Override
	public Users getUserAuthentication(String emailId, String password) {
		// TODO Auto-generated method stub
		// create the session object
		Session session = sessionFactory.getCurrentSession();
		// retrieve the users object
		List<Users> lstusers = session.createQuery("FROM Users WHERE emailId=:emailId AND password=:password", Users.class)
				.setParameter("emailId", emailId)
				.setParameter("password", password)
				.getResultList();
		if (lstusers.size() > 0) {
			return lstusers.get(0);
		}
		return null;
	}

	@Override
	public List<Users> searchUserByName(String keyword) {
		// TODO Auto-generated method stub
		// create the session object
		Session session = sessionFactory.getCurrentSession();
		// retrieve the users by name
		List<Users> lstusers = session.createQuery("FROM Users WHERE firstName like %:keyword%", Users.class)
				.setParameter("keyword", keyword)
				.getResultList();
		return lstusers;
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		// create the session object
		Session session = sessionFactory.getCurrentSession();
		// return the retrieved users list
		return session.createQuery("FROM Users", Users.class).getResultList();
	}

}
