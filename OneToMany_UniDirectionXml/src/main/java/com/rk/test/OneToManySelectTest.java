package com.rk.test;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.PhoneNumber;
import com.rk.entity.UserInfo;
import com.rk.utility.HibernateUtil;

public class OneToManySelectTest {

	
	public static void main(String[] args) {
	
		//properties
		Transaction tx=null;
		boolean flag=false;
		
		//get session
		Session ses=HibernateUtil.getSession();
	
		try {
			
			//begin tx		
			if(!ses.getTransaction().isActive())
			{
				tx=ses.beginTransaction();
				
				//load parent obj
				Query query=ses.createQuery("from UserInfo");
				List<UserInfo> list=query.getResultList();
			
				//print parent class
				list.forEach(user->{
					System.out.println("parent :: "+user);
					
					//get associated child also print
					Set<PhoneNumber> child=user.getPhones();
															child.forEach(ph->{
																	System.out.println("child :: "+ph);
															});//child
				});//parent

						// list.forEach(System.out::println);
			}//if	
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			
		}
		catch (Exception e) {
		e.printStackTrace();
		
		}
		
		//show the result or save the object
		
		finally {
			
			//close all
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//main
}//class
