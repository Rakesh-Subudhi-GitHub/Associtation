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

public class OneToMany_Bi_HQLJoinDAOImpl implements OneToMany_BI_HQLjoin_DAO {

	@Override
	public void loadDataUsingParent() {
		
		// get Session
			Session ses=HibernateUtil.getSession();
			Transaction tx=null;
				
			try {
			if(!ses.getTransaction().isActive())
					 tx=ses.beginTransaction();
		
			//execute HQL query
		  Query query=ses.createQuery("from UserInfo");
			
		  //execute query
		  List<UserInfo> userList=query.getResultList();
					
		  //print the result
		  userList.forEach(user->{
			  System.out.println("parent ::  "+user);
			  
			  //child load
			  Set<PhoneNumber> ph=user.getPhones();
			  ph.forEach(phone->{
				  System.out.println("child ::  "+phone);
			  });
		  });
				}//try
				
				catch(HibernateException he) {
					he.printStackTrace();
				}
				
				finally {
					//close  objs
					HibernateUtil.closeSessionFactory();
				}
		
	}//method
	
}//class
