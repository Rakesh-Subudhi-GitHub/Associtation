package com.rk.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.PhoneNumber;
import com.rk.entity.UserInfo;
import com.rk.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveDataUsingParent() {
		//properties
		Transaction tx=null;
		boolean flag=false;
		
		//get session
		Session ses=HibernateUtil.getSession();
		
		//prepare object
		//child object
		PhoneNumber phno=new PhoneNumber(909999l,"residence","home");
		PhoneNumber phno1=new PhoneNumber(808888l,"permanet","office");
		PhoneNumber phno2=new PhoneNumber(707777l,"residence","personal");
		PhoneNumber phno3=new PhoneNumber(707777l,"residence","personal");
		
		Map<String,PhoneNumber> mapphoneset=Map.of("phone1",phno,"phone2",phno1,"phone3",phno3); //store all phoneNumber in one user 
		
		//parent class
			//store all details of user
		UserInfo user=new UserInfo();
		
		user.setUsername("raka");
		user.setAddrs("hyd");
		user.setPhones(mapphoneset);
		
		try {
			
			//begin tx		
			if(!ses.getTransaction().isActive())
			{

			tx=ses.beginTransaction();
				
				//save objs
				ses.save(user);
				flag=true;
			
			}//if	
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch (Exception e) {
		e.printStackTrace();
		flag=false;
		}
		
		//show the result or save the object
		
		finally {
			
			if(flag)
			{
				tx.commit();
				System.out.println("User details are saved :::");
				System.out.println(user);
			}
			else
			{
				tx.rollback();
				System.out.println("user details are not saved ::::");
				return;
			}
			
			//close all
			HibernateUtil.closeSessionFactory();
		}//finally

	}//method

	@Override
	public void deletOneSpecificChild_InParent() {
		
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
					UserInfo user=ses.get(UserInfo.class,3);
					
					//load all child in user(Parent)
					Map<String,PhoneNumber> childs=user.getPhones();
					
					//delete specific child in help of index value 
						//delete 1st index then
					childs.remove("phone1");//direct map- key value insert 
					flag=true;
					
					}//if	
				}//try
				catch (HibernateException he) {
					he.printStackTrace();
					flag=false;
				}
				catch (Exception e) {
				e.printStackTrace();
				flag=false;
				}
				
				//show the result or save the object
				
				finally {
					
					if(flag)
					{
						tx.commit();
						System.out.println("Delete one specific child in parent obj  :::");
						
					}
					else
					{
						tx.rollback();
						System.out.println("Not delete specific child obj ::::");
						return;
					}
					
					//close all
					HibernateUtil.closeSessionFactory();
				}//finally
	}//method
}//class
