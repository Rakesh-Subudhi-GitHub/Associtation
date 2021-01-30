package com.rk.test;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.PhoneNumber;
import com.rk.entity.UserInfo;
import com.rk.utility.HibernateUtil;

public class OneToManyInsertTest {

	
	public static void main(String[] args) {
	
		//properties
		Transaction tx=null;
		boolean flag=false;
		
		//get session
		Session ses=HibernateUtil.getSession();
		
		//prepare object
		//child object
		PhoneNumber phno=new PhoneNumber(799999l,"residence","home");
		PhoneNumber phno1=new PhoneNumber(788888l,"permanet","office");
		PhoneNumber phno2=new PhoneNumber(777777l,"residence","personal");
		
		Set<PhoneNumber> phoneset=Set.of(phno,phno1,phno2); //store all phoneNumber in one user 
		
		//parent class
			//store all details of user
		UserInfo user=new UserInfo();
		
		user.setUsername("ritu");
		user.setAddrs("ctc");
		user.setPhones(phoneset);
		
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
		
	}//main
}//class
