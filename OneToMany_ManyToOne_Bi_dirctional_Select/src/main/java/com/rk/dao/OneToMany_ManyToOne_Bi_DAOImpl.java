package com.rk.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.PhoneNumber;
import com.rk.entity.UserInfo;
import com.rk.utility.HibernateUtil;

public class OneToMany_ManyToOne_Bi_DAOImpl implements OneToMany_ManyToOne_Bi_DAO {

	@Override
	public void loadDataUsingParent() {
	
				//get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				
				try {
					if(!ses.getTransaction().isActive())
						tx=ses.beginTransaction();
				
					//Load parent object
				  Query query=ses.createQuery("from UserInfo");
				  List<UserInfo> list=query.getResultList();
					
					list.forEach(user->{
						System.out.println("parent::"+user.getUserId()+"  "+user.getUsername()+"  "+user.getAddrs());
						
						//get associated childs of a parent
						Set<PhoneNumber> childs=user.getPhones();
						System.out.println(childs.isEmpty());
						childs.forEach(ph->	System.out.println("child :"+ph));
					});
					
				}//try
				
				catch(HibernateException he) {
					he.printStackTrace();
				}//catch
				
				finally {
				
					//close session factory
					HibernateUtil.closeSessionFactory();
				
				}//finally
		
	}//method

	@Override
	public void loadDataUsingChild() {
		
				//get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				
				try {
					if(!ses.getTransaction().isActive())
						tx=ses.beginTransaction();
					
					//execute QBC logic 
					Query query=ses.createQuery("from PhoneNumber");
					List<PhoneNumber> list=query.getResultList();
					
					list.forEach(ph->{
						System.out.println("child::"+ph);
						UserInfo user=ph.getUser();
						System.out.println("Parent ::"+user);
					});
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
				}//catch
				
				finally {
						//close session factory
					HibernateUtil.closeSessionFactory();
				}//finally
				
	}//method

}//class
