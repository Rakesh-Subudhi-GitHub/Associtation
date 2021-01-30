package com.rk.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.PhoneNumber;
import com.rk.entity.UserInfo;
import com.rk.utility.HibernateUtil;

public class SoluctionDAOImpl implements SoluctionDAO {

	@Override
	public void loadDataUsingHQL_JOIN_Soluction2(){
		
		// get Session
			Session ses=HibernateUtil.getSession();
			Transaction tx=null;
				
			try {
			if(!ses.getTransaction().isActive())
					 tx=ses.beginTransaction();
		
			//execute HQL query
			  Query query=ses.createQuery("select u from UserInfo  u inner join fetch u.phones ph");
			  
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
