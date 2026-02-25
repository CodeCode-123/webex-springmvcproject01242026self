package com.code.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.entity.Item;
import com.code.mvc.entity.ItemOrder;
@Repository
public class ItemOrderDAOImpl implements ItemOrderDAO {

			//inject the Sessionfactory
		@Autowired
		SessionFactory sessionFactory;
		@Override
		public int add(ItemOrder itemOrder) {
			//create the session object using the Session factory
			Session session=sessionFactory.getCurrentSession();
			
			// save/upate the customer ... finally LOL
			//save or update
			//if the primarykey id is null -- save as new new record
			//if the primarykey id is not null -- update the record
			session.save(itemOrder);
			//close the session
			//session.close();
				return  itemOrder.getOrderId();
		}

		@Override
		public int update(ItemOrder itemOrder) {
			//create the session object using the Session factory
					Session session=sessionFactory.getCurrentSession();
					
					// save/upate the customer ... finally LOL
					//save or update
					//if the primarykey id is null -- save as new new record
					//if the primarykey id is not null -- update the record
					session.saveOrUpdate(itemOrder);
					//close the session
					//session.close();
						return  itemOrder.getOrderId();
		}

		@Override
		public int delete(ItemOrder itemorder) {
			//create the object of the Session using the SessionFactory
					Session session=sessionFactory.getCurrentSession();
					//search the student eixts the id exists or not
					ItemOrder item1=	session.get(ItemOrder.class, itemorder.getOrderId());
				//check the std is null or null if null means no record
				if(item1==null)
				{
					return -1;//no record found; 
				}
				//if found then delete the record
				session.delete(item1);
				//close the session
				//session.close();
					return 1;//record is updated successfully	
		}

		@Override
		public int delete(int id) {
			//create the object of the Session using the SessionFactory
			Session session=sessionFactory.getCurrentSession();
			//search the student eixts the id exists or not
			ItemOrder item1=	session.get(ItemOrder.class, id);
		//check the std is null or null if null means no record
		if(item1==null)
		{
			return -1;//no record found; 
		}
		//if found then delete the record
		session.delete(item1);
		//close the session
		//session.close();
			return 1;//record is updated successfully
		}

		@Override
		public List<ItemOrder> getAll() {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
		//createCriteria the object provided by the  HiberNate
			//we pass the class and we get the list of the object
			//select * from student
	List<ItemOrder> itemOrders=currentSession.createCriteria(ItemOrder.class).list();
	return itemOrders;
		}

		@Override
		public ItemOrder getById(int id) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			//search the student eixts the id exists or not
			ItemOrder item=	session.get(ItemOrder.class, id);
			return item;
		}
}
