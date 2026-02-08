package com.code.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.entity.Item;  
@Repository
public class ItemDAOImpl implements ItemDAO {

	// inject the Sessionfactory
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int add(Item item) {
		// create the session object using the Session factory
		Session session = sessionFactory.getCurrentSession();
		// save/upate the customer ... finally LOL
		// save or update
		// if the primarykey id is null -- save as new new record
		// if the primarykey id is not null -- update the record
		session.persist(item);
		// close the session
		// session.close();
		return item.getItemId();
	}

	@Override
	public int update(Item item) {
		// create the session object using the Session factory
		Session session = sessionFactory.getCurrentSession();
		// save/upate the customer ... finally LOL
		// save or update
		// if the primarykey id is null -- save as new new record
		// if the primarykey id is not null -- update the record
		session.merge(item);
		// close the session
		// session.close();
		return item.getItemId();
	}

	@Override
	public int delete(Item item) {
		// create the object of the Session using the SessionFactory
		Session session = sessionFactory.getCurrentSession();
		// search the student eixts the id exists or not
		Item item1 = session.get(Item.class, item.getItemId());
		// check the std is null or null if null means no record
		if (item1 == null) {
			return -1;// no record found;
		}
		// if found then delete the record
		session.delete(item1);
		// close the session
		// session.close();
		return 1;// record is updated successfully
	}

	@Override
	public int delete(int id) {
		// create the object of the Session using the SessionFactory
		Session session = sessionFactory.getCurrentSession();
		// search the student eixts the id exists or not
		Item item1 = session.get(Item.class, id);
		// check the std is null or null if null means no record
		if (item1 == null) {
			return -1;// no record found;
		}
		// if found then delete the record
		session.delete(item1);
		// close the session
		// session.close();
		return 1;// record is updated successfully
	}

	@Override
	public List<Item> getAll() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// createCriteria the object provided by the HiberNate
		// we pass the class and we get the list of the object
		// select * from student
		List<Item> categories = currentSession.createCriteria(Item.class).list();
		return categories;
	}

	@Override
	public Item getById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		// search the student eixts the id exists or not
		Item item = session.get(Item.class, id);
		return item;
	}

	@Override
	public List<Item> getItemByCategoryName(String categoryname) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		// search the student eixts the id exists or not
		List<Item> items = session.createQuery("from Item where CategoryName=:catname")
				.setParameter("catname", categoryname).getResultList();
		return items;

	}

	@Override
	public List<Item> getItemByCategoryId(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		// search the student eixts the id exists or not
		List<Item> items = session.createQuery("from Item where categoryId=:catid").setParameter("catid", id)
				.getResultList();
		return items;
	}
}
