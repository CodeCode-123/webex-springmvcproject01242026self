package com.code.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.entity.Item;
import com.code.mvc.entity.ItemOrder;
import com.code.mvc.entity.ItemOrderDetails;
@Repository
public class ItemOrderDetailsDAOImpl implements ItemOrderDetailsDAO {

			//inject the Sessionfactory
		@Autowired
		SessionFactory sessionFactory;
		@Override
		public int add(ItemOrderDetails itemOrder) {
			//create the session object using the Session factory
			Session session=sessionFactory.getCurrentSession();
			
			// save/upate the customer ... finally LOL
			//save or update
			//if the primarykey id is null -- save as new new record
			//if the primarykey id is not null -- update the record
			session.save(itemOrder);
			//close the session
			//session.close();
				return  itemOrder.getItemOrderId();
		}

		@Override
		public int update(ItemOrderDetails itemOrder) {
			//create the session object using the Session factory
					Session session=sessionFactory.getCurrentSession();
					
					// save/upate the customer ... finally LOL
					//save or update
					//if the primarykey id is null -- save as new new record
					//if the primarykey id is not null -- update the record
					session.saveOrUpdate(itemOrder);
					//close the session
					//session.close();
						return  itemOrder.getItemOrderId();
		}

		@Override
		public int delete(ItemOrderDetails itemOrder) {
			//create the object of the Session using the SessionFactory
					Session session=sessionFactory.getCurrentSession();
					//search the student eixts the id exists or not
					ItemOrderDetails item1=	session.get(ItemOrderDetails.class, itemOrder.getItemOrderId());
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
			ItemOrderDetails item1=	session.get(ItemOrderDetails.class, id);
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
		public List<ItemOrderDetails> getAll() {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
		//createCriteria the object provided by the  HiberNate
			//we pass the class and we get the list of the object
			//select * from student
	List<ItemOrderDetails> itemorders=currentSession.createCriteria(ItemOrderDetails.class).list();
	return itemorders;
		}

		@Override
		public ItemOrderDetails getById(int id) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			//search the student eixts the id exists or not
			ItemOrderDetails item=	session.get(ItemOrderDetails.class, id);
			return item;
		}

		@Override
		public List<ItemOrderDetails> getByOrderId(int id) {
			Session session=sessionFactory.getCurrentSession();
			//search the student eixts the id exists or not
			List<ItemOrderDetails> items=	session.createQuery("from ItemOrderDetails where order_id='"+id+"'").getResultList();
			return items;
		}
}
