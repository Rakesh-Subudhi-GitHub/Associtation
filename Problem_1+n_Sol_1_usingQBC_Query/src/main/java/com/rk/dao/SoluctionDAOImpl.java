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
	public void loadDataUsingQBC_Soluction1(){
		
		// get Session
			Session ses=HibernateUtil.getSession();
			Transaction tx=null;
				
			try {
			if(!ses.getTransaction().isActive())
					 tx=ses.beginTransaction();
		
			//execute QBC query
			  Criteria criteria=ses.createCriteria(UserInfo.class);
			  
			//in userInfo.hbm.xml use one tag
										// fetch="join" then solve the problem
			
			  //(or) not write that area then write here
			  
			  criteria.setFetchMode("phones",FetchMode.JOIN);
		  
			  //execute query
		  List<UserInfo> userList=criteria.list();
					
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

	@Override
	public void loadDataUsingJPQBC_Soluction1() {
		
					// get Session
					Session ses=HibernateUtil.getSession();
					Transaction tx=null;
						
					try {
					if(!ses.getTransaction().isActive())
							 tx=ses.beginTransaction();
				
					//execute JPQBC query
					//Create CriteriaBuilder
					CriteriaBuilder builder=ses.getCriteriaBuilder();  
					
					//create CriteriaQuery object
					CriteriaQuery<UserInfo> ctquery=builder.createQuery(UserInfo.class);
					
					//create ROOT object
					Root<UserInfo> root=ctquery.from(UserInfo.class);
					
					//soluction
					root.fetch("phones");
					
					//add Root Object to CriteriaQuery Object
					ctquery.select(root);
					
					//prepare Query obj
					Query query=ses.createQuery(ctquery);
				  
				//execute query
				  List<UserInfo> userList=query.list();
							
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
