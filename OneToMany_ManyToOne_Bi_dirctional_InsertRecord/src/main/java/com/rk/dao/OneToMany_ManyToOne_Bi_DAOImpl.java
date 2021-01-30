package com.rk.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.PhoneNumber;
import com.rk.entity.UserInfo;
import com.rk.utility.HibernateUtil;

public class OneToMany_ManyToOne_Bi_DAOImpl implements OneToMany_ManyToOne_Bi_DAO {

	@Override
	public void saveDataUsingParent() {
		
		//properties
		//properties
				Transaction tx=null;
				boolean flag=false;
				
				//get session
				Session ses=HibernateUtil.getSession();
				
				//prepare object
				//child object
				PhoneNumber phno=new PhoneNumber(989999l,"resihence","homee");
				PhoneNumber phno1=new PhoneNumber(878888l,"pehmanet","officee");
				
				
				Set<PhoneNumber> phoneset=Set.of(phno,phno1); //store all phoneNumber in one user 
				
				//parent class
					//store all details of user
				UserInfo user=new UserInfo();
			
				//Many to one connection so
				
				 //set parent to childs
				 phno.setUser(user);
				 phno1.setUser(user);
				 
				user.setUsername("raka");
				user.setAddrs("hyd");
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

	}//method

	@Override
	public void saveDataUsingChild() {
		
		//get Session
				Session ses=HibernateUtil.getSession();
		
		//prepare objects
			 //parent obj
			 UserInfo user=new UserInfo("jani","mumbai");
	
			 //child objs
			PhoneNumber ph1=new PhoneNumber(16799999L,"personal","airtel");
			PhoneNumber ph2=new PhoneNumber(2378888L,"office","vi");
	
			//set parent to childs
				 ph1.setUser(user);
				 ph2.setUser(user);
			
				 //set childs to parent
				Set<PhoneNumber> phonesSet=Set.of(ph1,ph2);
				user.setPhones(phonesSet);
				Transaction tx=null;
				boolean flag=false;
				
				try {
					//begin Tx
					if(!ses.getTransaction().isActive())
						 tx=ses.beginTransaction();
					//save objs
					ses.save(ph1);
					ses.save(ph2);
					
					flag=true;
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
					flag=false;
				}
				finally {
					//Tx Mgmt
					if(flag) {
						tx.commit();
						System.out.println("parent to child objs are saved");
					}
					else {
						tx.rollback();
						System.out.println("parent to child objs are not saved");
					}
						//close session factory
					HibernateUtil.closeSessionFactory();
				
				}//finally
				
	}//method

}//class
