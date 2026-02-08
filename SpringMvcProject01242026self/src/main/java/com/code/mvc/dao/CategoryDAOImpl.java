package com.code.mvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.entity.Category;



//add the Repositator
@Repository
public class CategoryDAOImpl implements CategoryDAO {
		//inject the Sessionfactory
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public int add(Category category) {
		//create the session object using the Session factory
		Session session=sessionFactory.getCurrentSession();
		// save/upate the customer ... finally LOL
		//save or update
		//if the primarykey id is null -- save as new new record
		//if the primarykey id is not null -- update the record
		session.persist(category);
		//close the session
		//session.close();
		return  category.getCategoryId();
	}

	@Override
	public int update(Category category) {
		// create the session object using the Session factory
		Session session = sessionFactory.getCurrentSession();
		// save/upate the customer ... finally LOL
		// save or update
		// if the primarykey id is null -- save as new new record
		// if the primarykey id is not null -- update the record
		session.merge(category);
		// close the session
		// session.close();
		return category.getCategoryId();
	}

	@Override
	public int delete(Category category) {
		// create the object of the Session using the SessionFactory
		Session session = sessionFactory.getCurrentSession();
		// search the student eixts the id exists or not
		Category category1 = session.get(Category.class, category.getCategoryId());
		// check the std is null or null if null means no record
		if (category1 == null) {
			return -1;// no record found;
		}
		// if found then delete the record
		session.delete(category1);
		// close the session
		// session.close();
		return 1;// record is updated successfully
	}

	@Override
	public int delete(int id) {
		// create the object of the Session using the SessionFactory
		Session session = sessionFactory.getCurrentSession();
		// search the student eixts the id exists or not
		Category category1 = session.get(Category.class, id);
		// check the std is null or null if null means no record
		if (category1 == null) {
			return -1;// no record found;
		}
		// if found then delete the record
		session.delete(category1);
		// close the session
		// session.close();
		return 1;// record is updated successfully
	}

	@Override
	public List<Category> getAll() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	    //createCriteria the object provided by the  HiberNate
		//we pass the class and we get the list of the object
		//select * from student
        List<Category> categories=currentSession.createCriteria(Category.class).list();
        return categories;
	}

	@Override
	public Category getById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		Category category1=	session.get(Category.class, id);
		return category1;
	}

	@Override
	public Category getCategoryByName(String catname) {
		Session session=sessionFactory.getCurrentSession();
		//createQuery("from <entity> where <columnname/filedname>=:parametername")
		Query query=session.createQuery("from Category where categoryName=:pcategoryname");
		query.setParameter("pcategoryname", catname);
		return (Category) query.uniqueResult();
	}
	@Override
	public List<Category> search(String catname) {
		Session session=sessionFactory.getCurrentSession();
		//createQuery("from <entity> where <columnname/filedname>=:parametername")
		Query query=session.createQuery("from Category where categoryName like:pcategoryname");
		query.setParameter("pcategoryname", "%"+catname+"%");
		return query.list();
	}
}
